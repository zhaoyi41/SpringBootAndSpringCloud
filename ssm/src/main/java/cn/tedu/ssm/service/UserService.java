package cn.tedu.ssm.service;

import java.util.List;

import cn.tedu.ssm.pojo.User;

public interface UserService {
	public List<User> find();

	public User get(Integer id);

	public void update(User user);

	public void insert(User user);

	public void delete(Integer id);
}
