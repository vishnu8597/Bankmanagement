package com.bms.dao;

import com.bms.model.BranchSearch;
import com.bms.model.BranchSearchDetails;
import com.bms.model.IfscSearch;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

/**
 * Purpose of this class is to access data from the database to enable branch and ifsc search
 * Filename: BranchSearchDao.java
 *
 * @author: Anish Devineni
 */

public class BranchSearchDao implements IBranchSearchDao {

  final String DB_URL = "jdbc:mysql://db-5308.cs.Dal.ca:3306/CSCI5308_3_DEVINT";
  final String DB_USER = "CSCI5308_3_DEVINT_USER";
  final String DB_PWD = "9nEWerA7YdR";
  private final JdbcTemplate jdbcTemplate;

  public BranchSearchDao() {
    this.jdbcTemplate = new JdbcTemplate(getDataSource());
  }

  public DataSource getDataSource() {
    DataSource dataSource = new DriverManagerDataSource(DB_URL, DB_USER, DB_PWD);
    return dataSource;
  }

  public String branchSearch(BranchSearchDetails branchSearchDetails) {
    List<BranchSearch> resultSet =
            jdbcTemplate.query(
                    "select * from branch where branchname= " + '"' + branchSearchDetails.getBranchname() + '"',
                    (rs, rowNum) ->
                            new BranchSearch(
                                    rs.getString("branchname"),
                                    rs.getString("ifsc"),
                                    rs.getString("address"),
                                    rs.getString("phonenumber")
                            )
            );

    String ifsc = "";
    for (BranchSearch branch : resultSet) {
      ifsc = branch.getIfsc();
    }
    return ifsc;
  }

  public String[] ifscSearch(String ifsc) {
    List<BranchSearch> resultSet =
            jdbcTemplate.query(
                    "select * from branch where ifsc= " + '"' + ifsc + '"',
                    (rs, rowNum) ->
                            new BranchSearch(
                                    rs.getString("branchname"),
                                    rs.getString("ifsc"),
                                    rs.getString("address"),
                                    rs.getString("phonenumber")
                            )
            );

    String[] branch = new String[100];
    int index = 0;
    for (BranchSearch ifscc : resultSet) {
      branch[index++] = ifscc.getBranchname();
      branch[index++] = ifscc.getAddress();
      branch[index++] = ifscc.getPhonenumber();
    }
    return branch;
  }

  public List<BranchSearch> checkifsc(IfscSearch ifscSearch) {
    List<BranchSearch> resultSet = jdbcTemplate.query(
            "select * from branch where ifsc= " + '"' + ifscSearch.getIfsccode() + '"',
            (rs, rowNum) ->
                    new BranchSearch(
                            rs.getString("branchname"),
                            rs.getString("ifsc"),
                            rs.getString("address"),
                            rs.getString("phonenumber")
                    )
    );
    return resultSet;
  }
}
