package com.sdajava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public enum DBConnection {
    INSTANCE;

    public static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    public static final String DB_URL
            = "jdbc:mysql://localhost/ksiegarnia?" +
            "useSSL=false&useJDBCCompliantTimezoneShift=" +
            "true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public final static String USER="root";
    public final static String PASS="";

    public static Statement setJdbcConnection () {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Lacze z BD...");
            connection =
                    DriverManager.getConnection(
                            DB_URL,USER,PASS);
            statement = connection.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return statement;
    }

    private DBConnection(){
        System.out.println("Test");
    }
}
