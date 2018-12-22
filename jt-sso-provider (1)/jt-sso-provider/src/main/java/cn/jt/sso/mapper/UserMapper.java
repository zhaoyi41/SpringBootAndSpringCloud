package cn.jt.sso.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import cn.jt.sso.pojo.User;

public interface UserMapper extends BaseMapper<User>{
	//扩展，用户检查 where ${type} = #{param}；type=username/phone/email
	@Select("SELECT COUNT(*) FROM tb_user WHERE ${type}=#{param}")
	public Integer check(@Param("type") String type,@Param("param") String param);
}
