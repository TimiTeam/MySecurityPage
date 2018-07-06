package com.gamil.timurworkspace.controller;


import com.gamil.timurworkspace.dao.RegistrationAndLoginUserImpl;
import com.gamil.timurworkspace.dao.interfaces.RegistrationUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/loginUser")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uname = req.getParameter("uname");
        String upass = req.getParameter("upass");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("error.jsp");
        RegistrationUser registration = new RegistrationAndLoginUserImpl();


        if(registration.isItRegisterUser(uname,upass)){

            HttpSession session = req.getSession();
            session.setAttribute("key",uname);

            requestDispatcher = req.getRequestDispatcher("welcome.jsp");

        }

        requestDispatcher.forward(req,resp);

    }
}
