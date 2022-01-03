package com.bms.services;

import java.sql.SQLException;

public interface ICheckFirstNameService {

    public boolean CheckFirstName(String firstName,String email) throws SQLException;
}
