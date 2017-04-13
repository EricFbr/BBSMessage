package com.oracleoaec.service.impl;

import java.util.List;

import com.oracleoaec.dao.IUserDao;
import com.oracleoaec.dao.impl.UserDaoImpl;
import com.oracleoaec.entity.User;
import com.oracleoaec.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao userDao = new UserDaoImpl();
	@Override
	public int register(User user) {
		int rows = 0;
		//查询是否有重名用户
		User u = userDao.queryUser(user.getName());
		if(u.getName()==null){
			//插入
			rows = userDao.addUser(user);
		}else{
			rows = -1;
		}
		return rows;
	}
	@Override
	public User login(User user) {
		return userDao.queryUser(user);
	}
	
}
