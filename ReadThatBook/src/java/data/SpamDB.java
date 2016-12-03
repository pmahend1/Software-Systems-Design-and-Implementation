/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Raka Choudhury
 */
public class SpamDB {
    public static int addSpam(String username,int bookid,String reporter,String reason) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query
                = "INSERT INTO spam (Book_ID, UserName, reporter, reason) "
                + "VALUES (?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, bookid);
            ps.setString(2,username);
            ps.setString(3,reporter);
            ps.setString(4,reason);
          
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("e="+e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

}
