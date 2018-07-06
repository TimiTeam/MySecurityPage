package com.gamil.timurworkspace.dao;


import com.gamil.timurworkspace.component.User;
import com.gamil.timurworkspace.dao.interfaces.RegistrationUser;
import org.apache.log4j.Logger;

import java.sql.*;

public class RegistrationAndLoginUserImpl implements RegistrationUser {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static final Logger LOGGER = Logger.getLogger(RegistrationUser.class);

    private static final String URL = "jdbc:mysql://localhost:3306/timur_base";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    private Connection connection;
    private PreparedStatement statement;


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER_NAME,PASSWORD);
    }

    private void closeAll(){
        if(connection != null ){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void registered(User u) {

        if(u != null) {

            LOGGER.info("This user will be added: "+u);
            try {
                connection = getConnection();
                statement = connection.prepareStatement("INSERT INTO user(name, last_name, login, password) VALUES " +
                        "(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, u.getName());
                statement.setString(2, u.getLastName());
                statement.setString(3, u.getLogin());
                statement.setString(4, u.getPassword());
                statement.execute();
                ResultSet keys = statement.getGeneratedKeys();

                if (keys.next()) {
                    LOGGER.info("This will be user id: "+keys);
                    u.setId(keys.getInt(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeAll();
            }
        }
    }

    public boolean isItRegisterUser(String login, String password) {
        User checkingUser = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT * FROM user WHERE login =? AND password =? ;");
            statement.setString(1,login);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                checkingUser = new User();
                checkingUser.setLogin(resultSet.getString("login"));
                checkingUser.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException|NullPointerException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }

     return checkingUser!=null;
    }
}
