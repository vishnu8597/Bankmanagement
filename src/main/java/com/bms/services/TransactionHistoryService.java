package com.bms.services;

import com.bms.dao.ITransactionHistoryDao;
import com.bms.dao.LoginDao;
import com.bms.dao.TransactionHistoryDao;
import com.bms.model.Customer;
import com.bms.model.TransactionDisplay;
import com.bms.model.UserLoginDetails;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the business logic to display the Transaction History of a customer.
 * Filename: TransactionHistoryService.java
 *
 * @author: Namit Prakash Dadlani
 */

public class TransactionHistoryService implements ITransactionHistoryService {

  private final ITransactionHistoryDao transactionHistoryDao;

  @Autowired
  public TransactionHistoryService() {
    this.transactionHistoryDao = new TransactionHistoryDao();
  }

  public List<TransactionDisplay> showAllTransactionHistory(String username) {
    List<TransactionDisplay> displayList = new ArrayList<>();
    displayList = transactionHistoryDao.fetchAllTransactionHistory(username);
    return displayList;
  }

  public List<TransactionDisplay> showWithinRangeTransactionHistory(String username, DateTime beginDate, DateTime endDate) {
    List<TransactionDisplay> displayList = new ArrayList<>();
    endDate = endDate.plusDays(1);
    displayList = transactionHistoryDao.fetchWithinRangeTransactionHistory(username, beginDate, endDate);
    return displayList;
  }

  public String fetchNameForTransactionHistory(String email) {
    UserLoginDetails userDetails = new UserLoginDetails();
    userDetails.setEmail(email);
    LoginDao loginDao = new LoginDao();
    List<Customer> fetchedCustomerObject = loginDao.verifyDetails(userDetails);
    return fetchedCustomerObject.get(0).getFirstName();
  }

  public String findHighestTransactions(List<TransactionDisplay> displayTransactions) {
    String displayText = "";
    BigDecimal highestCredit = BigDecimal.ZERO;
    BigDecimal highestDebit = BigDecimal.ZERO;
    for (TransactionDisplay item : displayTransactions) {
      if (item.getMode().equals("credit") && highestCredit.compareTo(item.getAmount()) < 0) {
        highestCredit = item.getAmount();
      } else if (item.getMode().equals("debit") && highestDebit.compareTo(item.getAmount()) < 0) {
        highestDebit = item.getAmount();
      }
    }
    if (highestCredit.compareTo(BigDecimal.ZERO) != 0) {
      displayText += "Highest Credit Amount: " + highestCredit;
    }
    if (highestDebit.compareTo(BigDecimal.ZERO) != 0) {
      displayText += "  Highest Debit Amount: " + highestDebit;
    }
    return displayText;
  }

}
