
package com.nitc.lab.dao;

import com.nitc.lab.entities.Admin;
import java.sql.*;

/**
 *
 * @author shrav
 */
public class AdminDao {
    private Connection con;

    public AdminDao(Connection con) {
        this.con = con;
    }
    
    public boolean saveAdmin(Admin admin){
        boolean f=false;
        try{
            String query = "insert into admin(id,pass,name,email) values (?,?,?,?)";
            PreparedStatement pstmt = this.con.prepareStatement(query);
            pstmt.setString(1, admin.getId());
            pstmt.setString(2, admin.getPass());
            pstmt.setString(3, admin.getName());
            pstmt.setString(4, admin.getEmail());
       
            pstmt.executeUpdate();
            f = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }
    
    public Admin getAdminIdAndPassword(String id, String pass) {
        Admin user = null;

        try {

            String query = "select * from admin where id =? and pass=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, pass);

            ResultSet set = pstmt.executeQuery();

            if (set.next()) {
                user = new Admin();

//             data from db
                String name = set.getString("name");
//             set to user object
                user.setName(name);

                user.setId(set.getString("id"));
                user.setPass(set.getString("pass"));
                user.setEmail(set.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
