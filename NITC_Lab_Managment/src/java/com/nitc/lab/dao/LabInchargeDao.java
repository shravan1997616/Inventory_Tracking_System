
package com.nitc.lab.dao;

import com.nitc.lab.entities.LabIncharge;
import java.sql.*;

public class LabInchargeDao {
     private Connection con;

    public LabInchargeDao(Connection con) {
        this.con = con;
    }
     
    public boolean saveLabIncharge(LabIncharge lab){
        boolean f=false;
        try{
            String query = "insert into labincharge(id,pass,name,email,lab) values (?,?,?,?,?)";
            PreparedStatement pstmt = this.con.prepareStatement(query);
            pstmt.setString(1, lab.getId());
            pstmt.setString(2, lab.getPass());
            pstmt.setString(3, lab.getName());
            pstmt.setString(4, lab.getEmail());
            pstmt.setString(5, lab.getLab());
       
            pstmt.executeUpdate();
            f = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }
    
    public LabIncharge getLabInchargeIdAndPassword(String id, String pass) {
        LabIncharge user = null;

        try {

            String query = "select * from labincharge where id =? and pass=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, pass);

            ResultSet set = pstmt.executeQuery();

            if (set.next()) {
                user = new LabIncharge();

//             data from db
                String name = set.getString("name");
//             set to user object
                user.setName(name);

                user.setId(set.getString("id"));
                user.setPass(set.getString("pass"));
                user.setEmail(set.getString("email"));
                user.setLab(set.getString("lab"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

}
