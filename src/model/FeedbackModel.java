package model;

import entity.Feedback;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FeedbackModel {
    public boolean userSend(Feedback feedback) {
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.64.2/hihih", "xuanhung", "");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT  INTO FeedBack (description ,status ) VALUE (?,'0')");
            preparedStatement.setString(1, feedback.getDescription());
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

    public List<Feedback> getFeedback() {
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.64.2/hihih", "xuanhung", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM FeedBack WHERE status = '0'");
            ResultSet rs = preparedStatement.executeQuery();
            List<Feedback> feedbacks = new ArrayList<Feedback>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String des = rs.getString("description");
                Feedback c = new Feedback(id, des);
                feedbacks.add(c);
            }
            System.out.println(preparedStatement);
            return feedbacks;
        } catch (SQLException e) {
            System.out.println("SQL" + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Feedback> getAllFeedback() {
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.64.2/hihih", "xuanhung", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM FeedBack");
            ResultSet rs = preparedStatement.executeQuery();
            List<Feedback> feedbacks = new ArrayList<Feedback>();
            while (rs.next()) {
                int allId = rs.getInt("id");
                String allDes = rs.getString("description");
                Feedback allFeedback = new Feedback(allId, allDes);
                feedbacks.add(allFeedback);
            }
            return feedbacks;
        } catch (SQLException e) {
            System.out.println("SQL" + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Feedback deleteFeedback(int id) {
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.64.2/hihih", "xuanhung", "");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM FeedBack WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            System.out.println(preparedStatement);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
