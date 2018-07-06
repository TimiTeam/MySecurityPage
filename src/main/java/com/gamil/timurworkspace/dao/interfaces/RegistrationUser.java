package com.gamil.timurworkspace.dao.interfaces;


import com.gamil.timurworkspace.component.User;

public interface RegistrationUser {

    void registered (User user);

    boolean isItRegisterUser(String login,String password);
}
