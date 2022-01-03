package com.bms.services;

import com.bms.dao.WithdrawTransactionDAO;
import com.bms.model.SavingsAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;

/**
 * this class deals with WithdrawTransaction functionality
 *  @author: Jainesh Desai
 */
@Service
public class WithdrawTransactionService implements IWithdrawTransactionService {

  @Autowired
  WithdrawTransactionDAO withdrawTransactionDAO;

  /*
   * @param name: name parameter takes email address as a parameter in method
   * @return: this method return list of user by name
   */
  @Override
  public List<SavingsAccount> findByName(String name) {

    return withdrawTransactionDAO.findByName(name);
  }

  /*
   * @param accountModel: takes object of SavingAccount
   * @param amount: amount is the amount entered by user from the frontend
   * @return: this method insert into database and does the withdraw
   *  transactionality
   * @throws SQLException
   */
  @Override
  public Boolean update(SavingsAccount accountModel, int amount) throws SQLException {

    return withdrawTransactionDAO.update(accountModel, amount);

  }
}



