/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.SignUpBean;
/**
 *
 * @author it3530216
 */




/**
 *
 * @author admin
 */
public class SignUpDAOImpl implements SignUpDAO {

    @Override
    public int createProfile(SignUpBean sub) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("gets here");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        int rowCount = 0;
        try {
            String myDB = "jdbc:derby://localhost:1527/Project353";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            
            String insertString;
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO Project353.ProjectUsers VALUES ('"
                    + sub.getUid()
                    + "','" + sub.getFname()
                    + "','" + sub.getLname()
                    + "','" + sub.getEmail()
                    + "','" + sub.getPass()
                    + "',0)";

            rowCount = stmt.executeUpdate(insertString);
            System.out.println("insert string =" + insertString);
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        
        return rowCount;
    }
}

