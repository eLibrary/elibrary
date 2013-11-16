package com.elib.entity;

// Generated Nov 16, 2013 10:36:05 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Userlibrary generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "userlibrary")
public class Userlibrary implements java.io.Serializable, IEntity<Integer> {

  private Integer id;
  private Book book;
  private User user;
  private Boolean isReaded;
  private Boolean isReviewed;

  public Userlibrary() {
  }

  public Userlibrary(Book book, User user, Boolean isReaded, Boolean isReviewed) {
    this.book = book;
    this.user = user;
    this.isReaded = isReaded;
    this.isReviewed = isReviewed;
  }

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "ID", unique = true, nullable = false)
  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "BookID")
  public Book getBook() {
    return this.book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "UserID")
  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Column(name = "IsReaded")
  public Boolean getIsReaded() {
    return this.isReaded;
  }

  public void setIsReaded(Boolean isReaded) {
    this.isReaded = isReaded;
  }

  @Column(name = "IsReviewed")
  public Boolean getIsReviewed() {
    return this.isReviewed;
  }

  public void setIsReviewed(Boolean isReviewed) {
    this.isReviewed = isReviewed;
  }

}
