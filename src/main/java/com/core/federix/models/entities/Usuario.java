/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.federix.models.entities;


public class Usuario {

    private Integer id;
    private String name;
    private String mail;
    private String password;

    public Usuario() {
    }

    public Usuario(int id, String name, String mail) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.password = "testing";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
