package com.sdajava.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBQuery {

    private DBConnection dbConnection;

    public void getSingleQuery (){
        Statement singleState = dbConnection.INSTANCE.setJdbcConnection();

        try {
            ResultSet resultSet =
                    singleState.executeQuery(
                            "select * from books where title=\"MySQL. Vademecum profesjonalisty\"");
            System.out.println("Wpis po update: ");
           while (resultSet.next()) {
                System.out.println(resultSet.getString("title") +
                        " " + resultSet.getString("author") +
                        " " + resultSet.getInt("page_count") +
                        " " + resultSet.getDouble("price") + " zł" +
                        " " + resultSet.getString("category") +
                        " " + resultSet.getString("isbn"));
            }
            resultSet.close();
            singleState.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getQuery () {

        Statement statement = dbConnection.INSTANCE.setJdbcConnection();

        try {
            ResultSet resultSet =
                   statement.executeQuery("select * from books");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("title") +
                        " " + resultSet.getString("author") +
                        " " + resultSet.getInt("page_count") +
                        " " + resultSet.getDouble("price") + " zł" +
                        " " + resultSet.getString("category") +
                        " " + resultSet.getString("isbn"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateQuery () {
        Statement stateUpdate = dbConnection.INSTANCE.setJdbcConnection();
        String sql =
                "update books set price=666.66 where title=\"MySQL. Vademecum profesjonalisty\"";
        System.out.println("Wykonuje update: " + sql);
        try {
            stateUpdate.executeUpdate(sql);
            stateUpdate.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
