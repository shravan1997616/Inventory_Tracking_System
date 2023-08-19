/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitc.lab.entities;

/**
 *
 * @author shrav
 */
public class System {
    private String id;
    private String oper;
    private String lab;
    private String status;

    public System(String id, String oper, String lab, String status) {
        this.id = id;
        this.oper = oper;
        this.lab = lab;
        this.status = status;
    }

    public System(String oper, String lab, String status) {
        this.oper = oper;
        this.lab = lab;
        this.status = status;
    }

    public System() {
    }

    public String getId() {
        return id;
    }

    public String getOper() {
        return oper;
    }

    public String getLab() {
        return lab;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    
}
