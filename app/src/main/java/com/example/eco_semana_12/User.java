package com.example.eco_semana_12;

public class User {
    private String username;
    private String nombre;
    private String edad;
    private String pass;
    private String id;

    public User(){
        this.username = "";
        this.nombre = "";
        this.edad = "";
        this.pass = "";
        this.id = "";
    }

    public User(String username, String nombre, String edad, String pass, String id) {
        this.username = username;
        this.nombre = nombre;
        this.edad = edad;
        this.pass = pass;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
