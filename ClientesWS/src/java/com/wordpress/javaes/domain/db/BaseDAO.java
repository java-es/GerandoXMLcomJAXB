package com.wordpress.javaes.domain.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author https://javaes.wordpress.com/
 */
public class BaseDAO {

    public BaseDAO() {
        try {
            Class.forName("com.mysql.jdbc.driver");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/javaes";
            Connection conn = DriverManager.getConnection(url, "root", "root");
            return conn;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
