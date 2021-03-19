/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Blob;

/**
 *
 * @author maria
 */
public class Book {

    private String title;
    private String author;
    private String base64Image;
    private Blob base64Image2;

    public Book() {
    }

    public Book(String title, String author, String base64Image) {
        this.title = title;
        this.author = author;
        this.base64Image = base64Image;
    }

    public Book(Blob base64Image2) {
        this.base64Image2 = base64Image2;
    }

    public Blob getBase64Image2() {
        return base64Image2;
    }

    public void setBase64Image2(Blob base64Image2) {
        this.base64Image2 = base64Image2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

}
