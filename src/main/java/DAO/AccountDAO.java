package DAO;

import Util.ConnectionUtil;
import Model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
        ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
            if(pkeyResultSet.next()){
                int generated_account_id = (int) pkeyResultSet.getLong(1);
                return new Account(generated_account_id, account.getUsername(), account.getPassword());
            }
        }catch(SQLException e){
        System.out.println(e.getMessage());
    }

    return null;
}
//2: Our API should be able to process User logins.

    public List<Account>login(String username, String password){
        Connection connection = ConnectionUtil.getConnection();
        List<Account> accounts = new ArrayList<>();
        try {
            String sql = ("select USERNAME, PASSWORD from ACCOUNT where USERNAME=? and PASSWORD=?");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Account account = new Account(rs.getInt("account_id"), rs.getString("username"),
                 rs.getString("password"));
                 accounts.add(account);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return accounts;
    }
}

