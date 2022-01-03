package com.bms.services;

import java.sql.SQLException;

public interface ICheckAddressService {
    public boolean CheckAddress(String address,String email) throws SQLException;
}
