package com.gn.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.user.service.UserService;
import com.gn.user.vo.User;

@WebServlet("/UserEditEndServlet")
public class UserEditEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserEditEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd = request.getParameter("user_pw");
		String name = request.getParameter("user_name");
//		User u = new UserService().edit(pwd,name,no);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
