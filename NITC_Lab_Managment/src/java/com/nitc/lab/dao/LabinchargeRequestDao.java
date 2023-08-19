/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitc.lab.dao;

import com.nitc.lab.entities.LabinchargeRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shrav
 */
public class LabinchargeRequestDao {
    private Connection con;

    public LabinchargeRequestDao(Connection con) {
        this.con = con;
    }

   public boolean saveRequest(LabinchargeRequest p){
        boolean f=false;
        try{
            String query = "insert into request(reqno,scomno,labname,labincname,labincid,systemid,titil,mess,status) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = this.con.prepareStatement(query);
            pstmt.setString(1, p.getReqno());
            pstmt.setString(2, p.getScoid());
            pstmt.setString(3, p.getLabname());
            pstmt.setString(4, p.getLabincname());
            pstmt.setString(5, p.getLabincId());
            pstmt.setString(6, p.getSystemId());
            pstmt.setString(7, p.getTitil());
            pstmt.setString(8, p.getMess());
            pstmt.setString(9, p.getStatus());
       
            pstmt.executeUpdate();
            f = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }
   
    public boolean update(String id,String value){
        boolean ans=false;
        try{
            String query = "update request set status = ? where reqno = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, value);
            pstmt.setString(2, id);
            pstmt.executeUpdate();
            ans=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return ans;
    }
    public List<LabinchargeRequest> getAllComplien(){
        List<LabinchargeRequest> list1 = new ArrayList<>();
        try{
            PreparedStatement p = con.prepareStatement("select * from request");
            ResultSet set = p.executeQuery();
            
            while(set.next()){
                String reqno = set.getString("reqno");
                String scomid = set.getString("scomno");
                String labname = set.getString("labname");
                String labincname = set.getString("labincname");
                String labincId = set.getString("labincId");
                String systemId = set.getString("systemId");
                String titil = set.getString("titil");
                String mess = set.getString("mess");
                String status = set.getString("status");
                Timestamp date = set.getTimestamp("ts");
                
                LabinchargeRequest compl = new LabinchargeRequest(reqno,scomid,labname,labincname,labincId,systemId,titil,mess,status,date);
                list1.add(compl);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list1;
    }
    
    public List<LabinchargeRequest> getAllComplien(String str){
        List<LabinchargeRequest> list1 = new ArrayList<>();
        try{
            String query = "select * from request where labname =?";
            PreparedStatement p = con.prepareStatement(query);
            p.setString(1, str);
            
            ResultSet set = p.executeQuery();
            
            while(set.next()){
                String reqno = set.getString("reqno");
                String scomid = set.getString("scomno");
                String labname = set.getString("labname");
                String labincname = set.getString("labincname");
                String labincId = set.getString("labincId");
                String systemId = set.getString("systemId");
                String titil = set.getString("titil");
                String mess = set.getString("mess");
                String status = set.getString("status");
                Timestamp date = set.getTimestamp("ts");
                
                LabinchargeRequest compl = new LabinchargeRequest(reqno,scomid,labname,labincname,labincId,systemId,titil,mess,status,date);
                list1.add(compl);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list1;
    }
    
}
