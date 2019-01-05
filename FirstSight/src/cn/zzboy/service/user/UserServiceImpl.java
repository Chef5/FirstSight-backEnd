package cn.zzboy.service.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zzboy.dao.user.*;
import cn.zzboy.pojo.*;
@Service("UserService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public User checkUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.checkUser(user);
	}

	@Override
	public int regUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.regUser(user);
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userMapper.getUserById(id);
	}

	@Override
	public int mdfUserNameandPhone(User user) {
		// TODO Auto-generated method stub
		return userMapper.mdfUserNameandPhone(user);
	}

	@Override
	public int mdfUserPassword(User user) {
		// TODO Auto-generated method stub
		return userMapper.mdfUserPassword(user);
	}
	
	
}
