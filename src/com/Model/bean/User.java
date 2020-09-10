package com.Model.bean;

import com.Enum.UserRole;
import com.Enum.UserStatus;

public class User {
    private int id;
    private String email, password;
    private UserRole role;
    private UserStatus status;

    public User() {
    }

    public User(int id, String email, String password, UserRole role, UserStatus status) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email=" + email  +
                ", password=" + password +
                ", role=" + role +
                ", status=" + status +
                '}';
    }
}
