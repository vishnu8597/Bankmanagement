package com.bms.dao;

import com.bms.controller.LoginController;
import com.bms.model.SavingsAccount;
import com.bms.services.IWithdrawTransactionService;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * This class manages the database operations related to Withdraw Transaction.
 * Filename: WithdrawTransactionDAO.java
 *
 * @author: Jainesh Ketan Desai
 */
@Service
public class WithdrawTransactionDAO extends JdbcDaoSupport implements IWithdrawTransactionService, IWithdrawTransactionDAO {

  private final JdbcTemplate jdbcTemplate;

  final DataSource dataSource;

  public WithdrawTransactionDAO(JdbcTemplate jdbcTemplate, DataSource dataSource) {

    this.jdbcTemplate = jdbcTemplate;
    this.dataSource = dataSource;
  }

  @PostConstruct
  private void initialize() {

    setDataSource(dataSource);
  }

  long myNum = Long.parseLong(IWithdrawTransactionService.generateRandom());
  String in = "Account" + "/" + "withdrawl" + "/" + myNum;

  /*this method return list of user by name
   * @param name: passes name for the given entry
   * @return: method return list of user by name
   */
  @Override
  public List<SavingsAccount> findByName(String name) {

    return jdbcTemplate.query("select * from ACCOUNTS where EMAIL=?", new Object[]{name}, new BankRowMapper());
  }

  /*
   *this method insert into database and does the withdraw transactionality
   * @param accountModel: it passes object of accountmodel
   * @param amount: paases the value entered by user
   * @return: returns boolean true or false
   * @throws SQLException
   */
  @Override
  public Boolean update(SavingsAccount accountModel, int amount) throws SQLException {

    int accountID = accountModel.getAccountId();
    String description = "Account Withdrawl";
    String mode = "debit";
    float currentBalance = accountModel.getAccountBalance() - amount;
    if (currentBalance >= 0) {
      String email = LoginController.Email;
      String sql_1 = "INSERT INTO transactions (timestamp" + "," +
          "description," +
          "ref_num,amount,mode,balance," +
          "from_account_number,email) VALUES (?,?,?,?,?,?,?,?)";
      int status = jdbcTemplate.update(sql_1,
          new Object[]{
              new DateTime().getMillis(),
              description,
              in,
              amount,
              mode,
              currentBalance,
              email,
              email
          });

      String sql_2 = "UPDATE ACCOUNTS SET ACCOUNT_BAL=? WHERE ACCOUNT_ID=?";
      int status1 = jdbcTemplate.update(sql_2, new Object[]{currentBalance, accountID});
      jdbcTemplate.getDataSource().getConnection().close();

      return status != 0 && status1 != 0;

    }

    return false;

  }

}

class BankRowMapper implements RowMapper<SavingsAccount> {

  @Override
  public SavingsAccount mapRow(ResultSet resultSet, int i) throws SQLException {

    SavingsAccount accountModel = new SavingsAccount();
    accountModel.setAccountId(resultSet.getInt("ACCOUNT_ID"));
    accountModel.setAccountType(resultSet.getString("ACCOUNT_TYPE"));
    accountModel.setAccountOpeningDate(resultSet.getDate("OPENING_DATE"));
    accountModel.setAccountEmail(resultSet.getString("EMAIL"));
    accountModel.setAccountBalance(resultSet.getFloat("ACCOUNT_BAL"));
    accountModel.setLastVisitDate(resultSet.getDate("LAST_VISIT_DATE"));

    return accountModel;
  }

}
