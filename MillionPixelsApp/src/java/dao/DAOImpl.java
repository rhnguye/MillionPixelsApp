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
//            String myDB = "jdbc:derby://localhost:1527/Project353";
            String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/mrrakho_Sp2016_UserPixels;create=true";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            
            String insertString;
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO Project353.Users VALUES ('"
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
//            String myDB = "jdbc:derby://localhost:1527/Project353";
            String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/mrrakho_Sp2016_UserPixels;create=true";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            String queryString = 
                    "select * from project353.Users where uid = "
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
            
            
                queryString="select pixelsbought from project353.donate where uid='"
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
//            String myDB = "jdbc:derby://localhost:1527/Project353";
            String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/mrrakho_Sp2016_UserPixels;create=true";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            String queryString = 
                    "select * from project353.donate"
                    + " order by pixelsbought desc";

            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(queryString);
            List<Donation> lod=new ArrayList<Donation>();
            while(rs.next()){
                lod.add(new Donation(rs.getString("uid"), rs.getString("displayname"), rs.getString("usstates"), rs.getInt("pixelsbought")));
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
//            String myDB = "jdbc:derby://localhost:1527/Project353";
            String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/mrrakho_Sp2016_UserPixels;create=true";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            String queryString = 
                    "select * from project353.donate";
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(queryString);
            List<Donation> lod=new ArrayList<Donation>();
            while(rs.next()){
                lod.add(new Donation(rs.getString("uid"), rs.getString("displayname"), rs.getString("usstates"), rs.getInt("pixelsbought")));
            }
            DBConn.close();
            return lod;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    @Override
    public int donate(int pbought, String dname, String uid, String state){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("gets here");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        int rowCount = 0;
        try {
//            String myDB = "jdbc:derby://localhost:1527/Project353";
            String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/mrrakho_Sp2016_UserPixels;create=true";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            
           
            String querystring;
            
            Statement stmt=DBConn.createStatement();
            querystring = "select count(*) from project353.donate";
            
            ResultSet rs = stmt.executeQuery(querystring);
            rs.next();
            int totalrows=rs.getInt(1)+1;
            
            
            String insertstring;
            insertstring="insert into project353.donate values(" //insert into project353.donate values(10,30,'jmunny','md')
                    + totalrows
                    + "," + pbought
                    + ",'" + dname
                    + "','" + uid
                    + "','" + state
                    + "')";
            PreparedStatement stmt2 = DBConn.prepareStatement(insertstring);
            //stmt=DBConn.prepareStatement(insertstring);
            rowCount=stmt2.executeUpdate();
            DBConn.close();
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        
        return rowCount;
        
    }
}

