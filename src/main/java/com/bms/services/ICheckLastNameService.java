package com.bms.services;

import java.sql.SQLException;

public interface ICheckLastNameService {

    public boolean CheckLastName(String lastName,String email) throws SQLException;
}
