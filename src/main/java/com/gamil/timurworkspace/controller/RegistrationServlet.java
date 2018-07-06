package com.gamil.timurworkspace.controller;



import com.gamil.timurworkspace.component.User;
import com.gamil.timurworkspace.dao.RegistrationAndLoginUserImpl;
import com.gamil.timurworkspace.dao.interfaces.RegistrationUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/registrationUser")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("uname");
        String lastName = req.getParameter("ulastname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");

        if(name.length()<3 || lastName.length()<3 || login.length() < 3 || password.length() < 3){

            dispatcher= req.getRequestDispatcher("error.jsp");

            dispatcher.forward(req,resp);

            destroy();

        }else {
            RegistrationUser registration = new RegistrationAndLoginUserImpl();

            if(!registration.isItRegisterUser(login,password)){

                registration.registered(new User(name, lastName, login, password));

            }
        }
        dispatcher.forward(req,resp);

    }
}
