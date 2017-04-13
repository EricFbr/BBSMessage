package com.oracleoaec.service;

import com.oracleoaec.entity.User;

public interface IUserService {
	/**
	 * 注册业务处理
	 * @param user 带有用户名和密码的用户对象
	 * @return >0成功 0失败
	 */
	public int register(User user);
	
	public User login(User user);
	
}
