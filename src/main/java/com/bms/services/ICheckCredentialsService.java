package com.bms.services;


import java.sql.SQLException;

public interface ICheckCredentialsService {

  public boolean checkNewEmail(String newemail) throws SQLException;


  public boolean checkPassword(String password,String email) throws SQLException;

}
