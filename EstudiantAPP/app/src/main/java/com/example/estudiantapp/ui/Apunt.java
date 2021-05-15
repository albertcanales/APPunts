package com.example.estudiantapp.ui;

import java.util.Date;

public class Apunt {
    private String pdfName;
    private String author;
    private String career;
    private String subject;
    private String type;
    private int pageCount;
    private String description;
    private Date date;

    public Apunt() {
    }

    public Apunt(String pdfName, String author, String career, String subject, String type, int pageCount, String description, Date date){
        this.pdfName = pdfName;
        this.author = author;
        this.career = career;
        this.subject = subject;
        this.type = type;
        this.pageCount = pageCount;
        this.description = description;
        this.date = date;
    }

    public String getPdfName() {
        return pdfName;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
