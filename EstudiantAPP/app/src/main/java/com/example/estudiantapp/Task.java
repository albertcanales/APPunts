package com.example.estudiantapp;

import java.util.Date;

public class Task {

    private String Nom;
    private String Assignatura;
    private Date date;

    // Constructor buit
    Task() {
        this.Nom = "";
        this.Assignatura = "";
        this.date = new Date();
    }

    // Constructor de tasques
    Task(String nom, String assignatura, Date date) {
        this.Nom = nom;
        this.Assignatura = assignatura;
        this.date = date;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getAssignatura() {
        return Assignatura;
    }

    public void setAssignatura(String assignatura) {
        Assignatura = assignatura;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
