package com.example.pis;

public class usuario {

    String email;
    String contraseña;

    public usuario(String email, String contraseña) {
        this.email = email;
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "usuario{" +
                "email='" + email + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}
