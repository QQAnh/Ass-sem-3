package model;

import entity.Account;
import entity.Feedback;
import entity.Phone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneModel {
    public boolean insert(Phone phone) {
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hihih", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT  INTO Phone (name , brand , price , description ) VALUE (?,?,?,?)");
            preparedStatement.setString(1, phone.getName());
            preparedStatement.setString(2, phone.getBrand());
            preparedStatement.setString(3, phone.getPrice());
            preparedStatement.setString(4, phone.getDescription());
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
    public List<Phone> getPhone() {
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hihih", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Phone");
            ResultSet rs = preparedStatement.executeQuery();
            List<Phone> phones = new ArrayList<Phone>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                String price = rs.getString("price");
                String description = rs.getString("description");
                Phone c = new Phone(id, name,brand,price,description);

                phones.add(c);
            }
            System.out.println(phones);
            System.out.println(preparedStatement);
            return phones;
        } catch (SQLException e) {
            System.out.println("SQL" + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
