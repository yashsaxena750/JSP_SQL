package org.example.untitled.model;

import org.example.untitled.config.conn;
import org.example.untitled.entity.edata;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

public class usermodel {

    private static String hashPassword(String plainPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(plainPassword.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashedPassword = no.toString(16);
            while (hashedPassword.length() < 128) {
                hashedPassword = "0" + hashedPassword;
            }
            return hashedPassword;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<edata> listusers(){

        final Logger logger = Logger.getLogger(usermodel.class.getName());
        List<edata> listusers = new ArrayList<edata>();
        Connection connect = conn.getConnection();
        Statement stmt = null;
        ResultSet rst = null;

        String query = "Select * from edata";
        try {
            stmt = connect.createStatement();
            rst = stmt.executeQuery(query);
            while (rst.next())
            {
                listusers.add(new edata());
            }

        } catch (Exception e) {
            logger.info(e.toString());
        }
        finally {
            try {
                stmt.close();
            } catch (Exception e) {
                logger.info(e.toString());
            }
        }


        return listusers;

    }

    public static int adduser(edata newedata)
    {
        final Logger logger = Logger.getLogger(usermodel.class.getName());
        Connection connect = null;
        PreparedStatement stmt = null;

        try{
            connect = conn.getConnection();
            String username = newedata.getUname();
            String email = newedata.getUemail();
            String password = newedata.getUpassword();
            String hashedPassword = hashPassword(password);

            String query;
            query = "insert into edata (uname,uemail,upassword) values(?,?,?)";
            //query = "INSERT INTO edata (uname, uemail, upassword) VALUES ('" + username + "', '" + email + "', '" + password + "')";
            try {
                stmt = connect.prepareStatement(query);
                stmt.setString(1,username);
                stmt.setString(2,email);
                stmt.setString(3,hashedPassword);
                stmt.execute();
            } catch (SQLException e) {
                logger.info("Error"+e);
                return -1;
            }

        } catch (Exception e) {
            logger.info("Error"+e);
            return -1;
        }

        return 0;
    }

}
