package com.sdajava.jdbc;

import java.sql.*;

public class Main {

    public static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    public static final String DB_URL
            = "jdbc:mysql://localhost/ksiegarnia?" +
            "useSSL=false&useJDBCCompliantTimezoneShift=" +
            "true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public final static String USER="root";
    public final static String PASS="";

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Lacze z BD...");
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
            statement = connection.createStatement();
            ResultSet resultSet =
                    statement.executeQuery("select * from books");

            while (resultSet.next()){
                System.out.println(resultSet.getString("title") +
                 " " + resultSet.getString("author") +
                " " + resultSet.getInt("page_count") +
                " " + resultSet.getDouble("price") + " zł" +
                " " + resultSet.getString("category") +
                " " + resultSet.getString("isbn"));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
