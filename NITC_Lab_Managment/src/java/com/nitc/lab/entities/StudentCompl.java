
package com.nitc.lab.entities;

import java.sql.*;

public class StudentCompl {
    private String cid;
    private String id;
    private String name;
    private String lab;
    private String title;
    private String disc;
    private Timestamp date;
    private String status;

    public StudentCompl(String cid, String id, String name, String lab, String title, String disc, Timestamp date, String status) {
        this.cid = cid;
        this.id = id;
        this.name = name;
        this.lab = lab;
        this.title = title;
        this.disc = disc;
        this.date = date;
        this.status = status;
    }

    public StudentCompl() {
    }

    public StudentCompl(String id, String name, String lab, String title, String disc, Timestamp date, String status) {
        this.id = id;
        this.name = name;
        this.lab = lab;
        this.title = title;
        this.disc = disc;
        this.date = date;
        this.status = status;
    }

    public String getCid() {
        return cid;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLab() {
        return lab;
    }

    public String getTitle() {
        return title;
    }

    public String getDisc() {
        return disc;
    }

    public Timestamp getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    

    
    
   
    
    
    
}
