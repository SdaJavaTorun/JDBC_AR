package com.sdajava.jdbc;

import java.sql.*;

public class DBQuery {

    private DBConnection dbConnection;

    public void getSingleQuery (){
        Connection connection = dbConnection.INSTANCE.setJdbcConnection();

        try {
            Statement singleState = connection.createStatement();
            ResultSet resultSet =
                    singleState.executeQuery(
                            "select * from employees where employee_id=133");
            System.out.println("Wpis po update: ");
           while (resultSet.next()) {
               System.out.println(resultSet.getString("first_name") +
                       " " + resultSet.getString("last_name") +
                       " " + resultSet.getInt("employee_id") +
                       " " + resultSet.getDouble("salary") + " $" +
                       " " + resultSet.getString("job_id") +
                       " " + resultSet.getString("email"));
            }
            resultSet.close();
            singleState.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getQuery () {
        Connection connection = dbConnection.INSTANCE.setJdbcConnection();


        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet =
                   statement.executeQuery("select * from employees");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("first_name") +
                        " " + resultSet.getString("last_name") +
                        " " + resultSet.getInt("employee_id") +
                        " " + resultSet.getDouble("salary") + " $" +
                        " " + resultSet.getString("job_id") +
                        " " + resultSet.getString("email"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateQuery () {
        Connection connection = dbConnection.INSTANCE.setJdbcConnection();
        String sql =
                "update employees set salary=66666.66 where employee_id=133";
        System.out.println("Wykonuje update: " + sql);
        try {
            Statement stateUpdate = connection.createStatement();
            stateUpdate.executeUpdate(sql);
            stateUpdate.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // poprawic laczenie z baza z klasy DBConnection

    public void updateQuery2nd() {
        Connection connection = dbConnection.INSTANCE.setJdbcConnection();
        String sql =
                "update employees set job_id = ? where employee_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2, "new value");
            preparedStatement.setInt(1, 1);
            preparedStatement.executeUpdate();

            String insert =
                    "insert into employees(first_name,last_name,email,hire_date,job_id)" +
                            " values (?,?,?,?,?)";
            PreparedStatement preparedStatement1 = connection.prepareStatement(insert);
            preparedStatement1.setString(1, "nowa wartosc");
            preparedStatement1.setString(2, "nowa wartosc");
            preparedStatement1.setString(3, "nowa wartosc");
            preparedStatement1.setDate(4, java.sql.Date.valueOf("2013-09-04"));
            preparedStatement1.setString(5, "sa_rep");

            preparedStatement1.executeUpdate();

            System.out.println("Wykonuje update drugim sposobem: " + sql);
            preparedStatement.close();
            preparedStatement1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
