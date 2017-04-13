package com.oracleoaec.dao;

import com.oracleoaec.entity.User;


public interface IUserDao {
	//根据姓名查询
	public User queryUser(String name);
	//添加用户
	public int addUser(User user);
	//登录验证
	public User queryUser(User user);
}
