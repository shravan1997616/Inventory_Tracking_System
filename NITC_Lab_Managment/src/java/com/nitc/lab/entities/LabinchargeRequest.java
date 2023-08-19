/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitc.lab.entities;

import java.sql.Timestamp;

/**
 *
 * @author shrav
 */
public class LabinchargeRequest {
    private String reqno;
    private String scoid;
    private String labname;
    private String labincname;
    private String labincId;
    private String systemId;
    private String titil;
    private String mess;
    private String status;
    private Timestamp date;

    public LabinchargeRequest(String reqno, String scoid, String labname, String labincname, String labincId, String systemId, String titil, String mess, String status, Timestamp date) {
        this.reqno = reqno;
        this.scoid = scoid;
        this.labname = labname;
        this.labincname = labincname;
        this.labincId = labincId;
        this.systemId = systemId;
        this.titil = titil;
        this.mess = mess;
        this.status = status;
        this.date = date;
    }

    public LabinchargeRequest() {
    }

    public LabinchargeRequest(String scoid, String labname, String labincname, String labincId, String systemId, String titil, String mess, String status, Timestamp date) {
        this.scoid = scoid;
        this.labname = labname;
        this.labincname = labincname;
        this.labincId = labincId;
        this.systemId = systemId;
        this.titil = titil;
        this.mess = mess;
        this.status = status;
        this.date = date;
    }

    public String getReqno() {
        return reqno;
    }

    public String getScoid() {
        return scoid;
    }

    public String getLabname() {
        return labname;
    }

    public String getLabincname() {
        return labincname;
    }

    public String getLabincId() {
        return labincId;
    }

    public String getSystemId() {
        return systemId;
    }

    public String getTitil() {
        return titil;
    }

    public String getMess() {
        return mess;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setReqno(String reqno) {
        this.reqno = reqno;
    }

    public void setScoid(String scoid) {
        this.scoid = scoid;
    }

    public void setLabname(String labname) {
        this.labname = labname;
    }

    public void setLabincname(String labincname) {
        this.labincname = labincname;
    }

    public void setLabincId(String labincId) {
        this.labincId = labincId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public void setTitil(String titil) {
        this.titil = titil;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    
    
    
    
    
    
    
}
