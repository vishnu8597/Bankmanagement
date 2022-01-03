package com.bms.dao;

import com.bms.model.*;

import java.sql.SQLException;
import java.util.List;

public interface IAccountUpdateDao {

  int update(FetchEmailDetails fetchEmailDetails, String email) throws SQLException;

  int updateAccountTable(FetchEmailDetails fetchEmailDetails, String email) throws SQLException;

  int updateFirstName(FetchFirstName fetchFirstName, String email) throws SQLException;

  int updateLastName(FetchLastName fetchLastName, String email) throws SQLException;

  int updateAddress(FetchAddressDetails fetchAddressDetails, String email) throws SQLException;

  List<Customer> select(String email) throws SQLException;

  void delete(String email) throws SQLException;

  int updateTranscations(FetchEmailDetails fetchEmailDetails, String email) throws SQLException;

  int updateNominee(FetchEmailDetails fetchEmailDetails, String email) throws SQLException;
}
