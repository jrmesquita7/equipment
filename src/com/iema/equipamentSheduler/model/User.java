package com.iema.equipamentSheduler.model;

public class User {

    private int id;
    private String name;
    private String email;
    private String role;

    public User(int id, String name, String email, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if(role == null || role.trim().isEmpty()) {
            throw new IllegalArgumentException("Cargo inválido");
        }
        this.role = role;
    }
}
