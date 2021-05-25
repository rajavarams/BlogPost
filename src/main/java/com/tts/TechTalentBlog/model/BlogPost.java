package com.tts.TechTalentBlog.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @CreationTimestamp
    private java.sql.Timestamp createdDate;

    @Column
    @UpdateTimestamp
    private java.sql.Timestamp updated;

    private String title;
    private String author;


    @Lob
    private String blogEntry;

    public BlogPost() {

    }

    public BlogPost(String title, String author, String blogEntry) {
        this.title = title;
        this.author = author;
        this.blogEntry = blogEntry;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }


    public Timestamp getUpdated() {
        return updated;
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

    public String getBlogEntry() {
        return blogEntry;
    }

    public void setBlogEntry(String blogEntry) {
        this.blogEntry = blogEntry;
    }

    @Override
    public String toString() {
        return "BlogPost [id=" + id + ", " +
                "title=" + title + ", " +
                "author=" + author + ", " +
                "blogEntry=" + blogEntry + "]";
    }
}