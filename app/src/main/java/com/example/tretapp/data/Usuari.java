package com.example.tretapp.data;

public class Usuari {
    private String nom;
    private String contrasena;
    private String grup;

    public Usuari(String nom, String contrasena, String grup) {
        this.nom = nom;
        this.contrasena = contrasena;
        this.grup = grup;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getGrup() {
        return grup;
    }

    public void setGrup(String grup) {
        this.grup = grup;
    }

    @Override
    public String toString() {
        return "Usuari{" +
                "nom='" + nom + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", grup='" + grup + '\'' +
                '}';
    }
}
