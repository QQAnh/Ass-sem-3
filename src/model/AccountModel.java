package model;

import entity.Account;


import java.sql.*;

public class AccountModel {

    public Account getAccountByUserNameAndPassword(String username, String password) {

        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.64.2/hihih", "xuanhung", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Account WHERE username = ? AND  password = ?");

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            Account account = null;
            while (rs.next()) {
                String exitusername = rs.getString(2);
                String exitpassword = rs.getString(3);
                int exitrole = Integer.parseInt(rs.getString(4));
                 account = new Account(exitusername, exitpassword, exitrole);
            }
//                System.out.println(exitusername);

            return account;


        } catch (SQLException e) {
            System.out.println("SQL" + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean insert(Account account) {
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.64.2/hihih", "xuanhung", "");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT  INTO Account (username , password , role ) VALUE (?,?,?)");
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setInt(3, account.getRole());
            preparedStatement.execute();
            System.out.println(preparedStatement);
            return true;
        } catch (SQLException e) {
            System.out.println("SQL" + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean getAccountByUserName(String username) {

        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.64.2/hihih", "xuanhung", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Account WHERE username = ? ");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(preparedStatement);
            boolean check = rs.first();
            System.out.println(check);
            return check;
        } catch (SQLException e) {
            System.out.println("SQL" + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Account getRoleByUsernam(String username){

        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.64.2/hihih", "xuanhung", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Account WHERE username = ? ");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(preparedStatement);
            Account account = null;

            while (rs.next()) {
                String exitusername = rs.getString(2);
                int exitrole = Integer.parseInt(rs.getString(4));
                account = new Account(exitusername, exitrole);
            }

            return account;

        } catch (SQLException e) {
            System.out.println("SQL" + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
