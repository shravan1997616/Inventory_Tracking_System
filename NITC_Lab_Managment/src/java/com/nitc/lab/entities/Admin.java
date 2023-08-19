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
public class Admin {
    private String id;
    private String pass;
    private String name;
    private String email;

    public Admin(String id, String pass, String name, String email) {
        this.id = id;
        this.pass = pass;
        this.name = name;
        this.email = email;
    }

    public Admin() {
    }

    public Admin(String pass, String name, String email) {
        this.pass = pass;
        this.name = name;
        this.email = email;
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
    
    
}
