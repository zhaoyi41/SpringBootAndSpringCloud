package cn.jt.sso.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.jt.sso.mapper.UserMapper;
import cn.jt.sso.pojo.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private RedisService redisService;
	@Autowired
	private UserMapper userMapper;
	
	private static final ObjectMapper MAPPER = new ObjectMapper();	//转换java对象变成json字符串
	//对于定死数据，硬编码
	private static final Map<Integer,String> PARAM_TYPE = new HashMap<Integer,String>();
	//初始化
	static {	//静态代码块，设置初始值
		PARAM_TYPE.put(1, "username");
		PARAM_TYPE.put(2, "phone");
		PARAM_TYPE.put(3, "email");
	}
	
	//检查数据是否可用，返回值只有0和1，唯一索引
	public Integer check(String param, Integer type) {
		return userMapper.check(PARAM_TYPE.get(type), param);
	}
	
	//用户注册
	public String register(User user) {
		//加密密码
		String newpasswd = DigestUtils.md5Hex(user.getPassword());
		user.setPassword(newpasswd);
		
		userMapper.insert(user);
		return user.getUsername();
	}
	
	//用户登录
	public String login(String username, String password) {
		//按用户名进行查询，然后获取密码和传入密码加密后比较
		User u = new User();
		u.setUsername(username);
		
		String ticket = null;
		User user = userMapper.selectOne(u);	//只按用户名查询
		if(user!=null) {
			String passwd = user.getPassword();
			String oldPasswd = DigestUtils.md5Hex(password);
	
			if(passwd.equals(oldPasswd)) {		//是系统用户
				try {
					//生成ticket，把用户信息写入到redis中，k（ticket）v（User的json串）
					//ticket要求：动态性（当前毫秒数、uuid）、唯一性（username）、隐秘性（md5）
					ticket = DigestUtils.md5Hex("JT_TICKET_" + System.currentTimeMillis() + username);
				
					//把ticket放入redis，ticket设置过期时间，习惯电商：7天
					user.setPassword(null);   //传输数据中不能有密码，泄漏安全
					String userJson = MAPPER.writeValueAsString(user);
					redisService.set(ticket, userJson, 60*60*24*7);		//编译jvm拿到计算后的值
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}
		}
		return ticket;
	}
	
	//根据ticket到redis中获取用户信息
	public String queryByTicket(String ticket) {
		String userJson = redisService.get(ticket);
		return userJson;
	}
}






