
package com.nitc.lab.dao;
import java.sql.*;
import com.nitc.lab.entities.StudentCompl;
import java.util.ArrayList;
import java.util.List;



public class StudentComplDao {
    private Connection con;

    public StudentComplDao(Connection con) {
        this.con = con;
    }
    public boolean saveComplain(StudentCompl p){
        boolean f=false;
        try{
            String query = "insert into complain(cid,id,name,lab,title,disc,status) values (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = this.con.prepareStatement(query);
            pstmt.setString(1, p.getCid());
            pstmt.setString(2, p.getId());
            pstmt.setString(3, p.getName());
            pstmt.setString(4, p.getLab());
            pstmt.setString(5, p.getTitle());
            pstmt.setString(6, p.getDisc());
            pstmt.setString(7, p.getStatus());
            
            pstmt.executeUpdate();
            f = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }
    
    public List<StudentCompl> getAllComplien(){
        List<StudentCompl> list1 = new ArrayList<>();
        try{
            PreparedStatement p = con.prepareStatement("select * from complain");
            ResultSet set = p.executeQuery();
            
            while(set.next()){
                String cid = set.getString("cid");
                String id = set.getString("id");
                String name = set.getString("name");
                String lab = set.getString("lab");
                String title = set.getString("title");
                String disc = set.getString("disc");
                Timestamp date = set.getTimestamp("ts");
                String status = set.getString("status");
                
                StudentCompl compl = new StudentCompl(cid,id,name,lab,title,disc,date,status);
                list1.add(compl);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list1;
    }
    public List<StudentCompl> getAllComplien(String k){
        List<StudentCompl> list1 = new ArrayList<>();
        try{
            
            String query = "select * from complain where lab =?";
            PreparedStatement p = con.prepareStatement(query);
            p.setString(1, k);

            ResultSet set = p.executeQuery();
            
            while(set.next()){
                String cid = set.getString("cid");
                String id = set.getString("id");
                String name = set.getString("name");
                String lab = set.getString("lab");
                String title = set.getString("title");
                String disc = set.getString("disc");
                Timestamp date = set.getTimestamp("ts");
                String status = set.getString("status");
                
                StudentCompl compl = new StudentCompl(cid,id,name,lab,title,disc,date,status);
                list1.add(compl);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list1;
    }
    
    public boolean update(String id,String value){
        boolean ans=false;
        try{
            String query = "update complain set status = ? where cid = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, value);
            pstmt.setString(2, id);
            
            pstmt.executeUpdate();
            ans = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return ans;
    }
}
