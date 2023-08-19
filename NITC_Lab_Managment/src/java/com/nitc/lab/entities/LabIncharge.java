
package com.nitc.lab.entities;

public class LabIncharge {
    private String id;
    private String pass;
    private String name;
    private String email;
    
    private String lab;

    public LabIncharge(String id, String pass, String name, String email,String lab) {
        this.id = id;
        this.pass = pass;
        this.name = name;
        this.email = email;
        this.lab = lab;
    }

    public LabIncharge() {
    }

    public LabIncharge(String pass, String name, String email) {
        this.pass = pass;
        this.name = name;
        this.email = email;
        this.lab = lab;
    }

    public String getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLab() {
        return lab;
    }
    
    
    public void setId(String id) {
        this.id = id;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }
    
    
}
