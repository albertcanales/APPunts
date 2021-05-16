package com.example.estudiantapp.db;

import java.io.Serializable;
import java.util.Date;

public class Apunt implements Serializable {
    private String pdfName;
    private String author;
    private String degree;
    private String subject;
    private String type;
    private Integer pageCount;
    private String description;
    private Date date;
    private Boolean isFavourite;

    public Apunt() {
    }

    public Apunt(String pdfName, String author, String degree, String subject, String type, int pageCount, String description, Date date, boolean isFavourite) {
        this.pdfName = pdfName;
        this.author = author;
        this.degree = degree;
        this.subject = subject;
        this.type = type;
        this.pageCount = pageCount;
        this.description = description;
        this.date = date;
        this.isFavourite = isFavourite;
    }

    public Apunt(String rpr) {
        String[] partes = rpr.split(",");
        pdfName = partes[0];
        author = partes[1];
        degree = partes[2];
        subject = partes[3];
        type = partes[4];
        pageCount = Integer.parseInt(partes[5]);
        description = partes[6];
        date = stringToDate(partes[7]);
        isFavourite = Boolean.parseBoolean(partes[8]);
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

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
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


    public boolean getIsFavourite() {
        return this.isFavourite;
    }

    public void setIsFavourite(boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

    String dateToString(Date date) {
        return String.valueOf(date.getYear()).concat("-").concat(String.valueOf(date.getMonth())).concat("-").
                concat(String.valueOf(date.getDate()));
    }

    Date stringToDate(String string) {
        String[] s = string.split("-");
        return new Date(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
    }

    public String toMemString(){
        return pdfName
                + "," + author
                + "," + degree
                + "," + subject
                + "," + type
                + "," + pageCount.toString()
                + "," + description
                + "," + dateToString(date)
                + "," + isFavourite.toString();
    }

    @Override
    public String toString() {
        return "Apunt{" +
                "pdfName='" + pdfName + '\'' +
                ", author='" + author + '\'' +
                ", degree='" + degree + '\'' +
                ", subject='" + subject + '\'' +
                ", type='" + type + '\'' +
                ", pageCount=" + pageCount +
                ", description='" + description + '\'' +
                ", date=" + date.toString() + '\'' +
                ", isFavourite=" + isFavourite.toString() +
                '}';
    }

}




