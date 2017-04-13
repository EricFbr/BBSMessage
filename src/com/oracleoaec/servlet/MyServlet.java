package com.oracleoaec.servlet;

import java.io.IOException;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.entity.User;
import com.oracleoaec.service.IUserService;
import com.oracleoaec.service.impl.UserServiceImpl;

public class MyServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);//调用doPost方法
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		IUserService ius= new UserServiceImpl();
		User user =new User(username,password);
		if(ius.login(user)!=null){
			
			
			
			//resp.sendRedirect("main.html");
		}else{
			resp.sendRedirect("readMsg.html");
		}
		
/*		IUserService ius = new UserServiceImpl();
		User myUser = new User("张三", "123");
		User login = ius.login(myUser);
		if (login.getName()!=null) {
			resp.sendRedirect("main.html");
		}else{
			resp.sendRedirect("register.html");
		}*/
		//int register = ius.register(myUser);
		//System.out.println(register>0?"成功":"失败");
	}
}







