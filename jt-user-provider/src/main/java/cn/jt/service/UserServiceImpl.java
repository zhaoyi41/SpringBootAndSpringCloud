package cn.jt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import cn.jt.mapper.UserMapper;
import cn.jt.pojo.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	public List<User> findAll(){
		return userMapper.selectList(null);
	}
	
	//按条件查询
	public List<User> find(User user){
		//处理where、order by、group  by。这种方式QBC
		EntityWrapper wrapper = new EntityWrapper();
		//MP有自己语法规则，条件里使用字段名称，{0}参数，第一个参数
		wrapper.where("name like {0}","%"+ user.getName()+"%");
		
		//设置where条件
		return userMapper.selectList(wrapper);
	}

	@Override
	public void add(User user) {
		userMapper.insert(user);
	}

	@Override
	public void update(User user) {
		EntityWrapper<User> wrapper = new EntityWrapper<>();
		wrapper.where("id={0}", user.getId());
		userMapper.update(user, wrapper);
	}

	@Override
	public void delete(Long id) {
		userMapper.deleteById(id);
	}
}





