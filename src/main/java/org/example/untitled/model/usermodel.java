package org.example.untitled.model;

import org.example.untitled.config.conn;
import org.example.untitled.entity.edata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class usermodel {

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
                listusers.add(new edata(rst.getInt("userid"),rst.getString("uname"),rst.getString("uemail"),rst.getString("upassword")));
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

}
