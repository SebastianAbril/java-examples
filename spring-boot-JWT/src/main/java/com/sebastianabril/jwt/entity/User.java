package com.sebastianabril.jwt.entity;

public class User {

    private Integer id;
    private String email;
    private String password;
    private Integer roleId;


    public User() {
    }

    public User(Integer id, String email, String password, Integer roleId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
