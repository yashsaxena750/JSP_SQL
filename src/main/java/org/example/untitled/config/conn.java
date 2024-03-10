package org.example.untitled.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class conn {

    public static Connection getConnection(){
        final Logger logger = Logger.getLogger(conn.class.getName());
        String dbURL = System.getenv("dburl");
        String dbuname = System.getenv("dnuname");
        String dbpassword = System.getenv("password");
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbuname, dbpassword);
          }
        catch (Exception e) {
            logger.info(e.toString());
        }

        return conn;
    }

}
