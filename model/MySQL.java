package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {

    public static ResultSet execute(String query) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/adyapana", "root", "abcd1234");
            Statement statement = connection.createStatement();

            if (query.toLowerCase().startsWith("select")) {
                ResultSet resultSet = statement.executeQuery(query);
                return resultSet;
            } else {
                statement.executeUpdate(query);
                return null;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
