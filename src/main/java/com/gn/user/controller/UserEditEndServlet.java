package com.gn.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gn.user.service.UserService;
import com.gn.user.vo.User;

@WebServlet(name="userEditEnd",urlPatterns = "/user/editEnd")
public class UserEditEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserEditEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String userNo = request.getParameter("user_no");
		HttpSession session = request.getSession(false);
		int userNo = 0;
		
		if(session != null) {
			User u = (User)session.getAttribute("user");
			userNo = u.getUser_no();
		}
		
		String pwd = request.getParameter("user_pw");
		String name = request.getParameter("user_name");
		int result = new UserService().editUser(userNo,pwd,name);
		RequestDispatcher view = null;
		if(result > 0) {
			view = request.getRequestDispatcher("/views/user/edit.jsp");
			view.forward(request, response);
		}
		else {
			System.out.println("실패했습니다.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
