/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitc.lab.dao;

import java.sql.*;
import com.nitc.lab.entities.System;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author shrav
 */
public class SystemDao {
    private Connection con;

    public SystemDao(Connection con) {
        this.con = con;
    }
    
    public boolean saveSystem(System sys){
        boolean f=false;
        try{
            String query = "insert into computer(id,oper,lab,status) values (?,?,?,?)";
            PreparedStatement pstmt = this.con.prepareStatement(query);
            pstmt.setString(1, sys.getId());
            pstmt.setString(2, sys.getOper());
            pstmt.setString(3, sys.getLab());
            pstmt.setString(4, sys.getStatus());
       
            pstmt.executeUpdate();
            f = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }
    
    public List<System> getAllSystem(String k){
        List<System> list1 = new ArrayList<>();
        try{
            
            String query = "select * from computer where lab =?";
            PreparedStatement p = con.prepareStatement(query);
            p.setString(1, k);

            ResultSet set = p.executeQuery();
            
            while(set.next()){
                String id = set.getString("id");
                String oper = set.getString("oper");
                String lab = set.getString("lab");
                String status = set.getString("status");
                
                
                System compl = new System(id,oper,lab,status);
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
            String query = "update computer set status = ? where id = ?";
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
