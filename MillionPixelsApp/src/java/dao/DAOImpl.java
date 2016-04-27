/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Donation;
import model.LoginBean;
import model.SignUpBean;
/**
 *
 * @author it3530216
 */




/**
 *
 * @author admin
 */
public class DAOImpl implements DAO {

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
                    + "')";

            rowCount = stmt.executeUpdate(insertString);
            System.out.println("insert string =" + insertString);
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        
        return rowCount;
    }
    
    @Override
    public LoginBean login(String username, String password){
        LoginBean lb=null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        try {
            String myDB = "jdbc:derby://localhost:1527/Project353";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            String queryString = 
                    "select * from project353.projectusers where uid = "
                    + "? and password = ?";

            // Note the use of a diff class, called PreparedStatement
            PreparedStatement pstmt = DBConn.prepareStatement( queryString );
            pstmt.setString( 1, username); // replace the 1st ? with username
            pstmt.setString( 2, password); // replace the 2nd ? with password
            ResultSet rs = pstmt.executeQuery( );
            
            boolean r = rs.next();
            if(r){
                lb = new LoginBean();
                lb.setEmail(rs.getString("email"));
                lb.setFname(rs.getString("firstname"));
                lb.setLname(rs.getString("lastname"));
            
            
                queryString="select pixelsbought from project353.pixels where uid='"
                        + username + "'";
                Statement stmt = DBConn.createStatement();
                rs = stmt.executeQuery(queryString);
                int pixelsbought=0;
                while(rs.next()){
                    pixelsbought+=rs.getInt("pixelsbought");
                }
                lb.setPixelsbought(pixelsbought);
            }
            DBConn.close();
            return lb;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Donation> topDonators(){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        try {
            String myDB = "jdbc:derby://localhost:1527/Project353";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            String queryString = 
                    "select * from project353.pixels"
                    + " order by pixelsbought desc";

            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(queryString);
            List<Donation> lod=new ArrayList<Donation>();
            while(rs.next()){
                lod.add(new Donation(rs.getString("uid"), rs.getString("displayname"), rs.getString("usstate"), rs.getInt("pixelsbought")));
            }
    
            DBConn.close();
            return lod;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Donation> allDonators() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        try {
            String myDB = "jdbc:derby://localhost:1527/Project353";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            String queryString = 
                    "select * from project353.pixels";

            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(queryString);
            List<Donation> lod=new ArrayList<Donation>();
            while(rs.next()){
                lod.add(new Donation(rs.getString("uid"), rs.getString("displayname"), rs.getString("usstate"), rs.getInt("pixelsbought")));
            }
    
            DBConn.close();
            return lod;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}

