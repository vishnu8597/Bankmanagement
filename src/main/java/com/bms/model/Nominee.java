package com.bms.model;

/**
 * Purpose of this class is to function as a model to fetch Nominee details
 * Filename: Nominee.java
 *
 * @author: Jainesh Ketan Desai
 */
public class Nominee {
  int id;
  String Name;
  String Relantionship;
  String email;

  public Nominee(String name, String relantionship, String email) {

    Name = name;
    Relantionship = relantionship;
    this.email = email;
  }

  public Nominee() {

  }

  public int getId() {

    return id;
  }

  public void setId(int id) {

    this.id = id;
  }

  public String getName() {

    return Name;
  }

  public void setName(String name) {

    Name = name;
  }

  public String getRelantionship() {

    return Relantionship;
  }

  public void setRelantionship(String relantionship) {

    Relantionship = relantionship;
  }

  public String getEmail() {

    return email;
  }

  public void setEmail(String email) {

    this.email = email;
  }
}
