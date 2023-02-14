package DAO;

import Util.ConnectionUtil;
import Model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AccountDAO{

    //1: Our API should be able to process new User registrations.

public Account CreateNewUser(Account account){
    Connection connection = ConnectionUtil.getConnection();
    try {
        String sql = "INSERT INTO account (account_id, username, password) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, account.getAccount_id());
        preparedStatement.setString(2, account.getUsername());
        preparedStatement.setString(3, account.getPassword());
        preparedStatement.executeUpdate();
        return account;
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    return null;
}
//2: Our API should be able to process User logins.

    public boolean authenticate(String username, String password)
            throws Exception {
        boolean isUser = false;
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("select USRNAME, PASSWORD from ACCOUNT where USERNAME=? and PASSWORD=?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                isUser = true;
                System.out.println("User authenticated successfully");
            } else {
                System.out.println("Invalid username or password!");
            }
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return isUser;
    }
}

