package com.bms.services;

import com.bms.model.TransactionDisplay;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This is the test class for TransactionHistoryService logic.
 * Filename: TransactionHistoryServiceTest.java
 *
 * @author: Namit Prakash Dadlani
 */

class TransactionHistoryServiceTest {

  @Test
  void showAllTransactionHistory() {
    TransactionHistoryService tsh = new TransactionHistoryService();
    List<TransactionDisplay> displayList = new ArrayList<>();
    displayList = tsh.showAllTransactionHistory("testuser@yahoo.com");
    assertTrue(displayList.size() > 0, "showAllTransactionHistory() not fetching data as expected.");
  }

  @Test
  void showWithinRangeTransactionHistory() {
    TransactionHistoryService tsh = new TransactionHistoryService();
    List<TransactionDisplay> displayList = new ArrayList<>();
    displayList = tsh.showWithinRangeTransactionHistory("testuser@yahoo.com", new DateTime("2021-07-01"), new DateTime("2021-07-21"));
    assertTrue(displayList.size() > 0, "showWithinRangeTransactionHistory() not fetching data as expected.");
  }

  @Test
  void fetchNameForTransactionHistory() {
    TransactionHistoryService tsh = new TransactionHistoryService();
    assertEquals("vishnu", tsh.fetchNameForTransactionHistory("testuser@yahoo.com"),
            "Not able to fetch correct name to display on Transaction History screen.");
  }

  @Test
  void findHighestTransactions_creditOnly() {
    TransactionDisplay t1 = new TransactionDisplay(1, "123",
            new BigDecimal("125"), "credit", new BigDecimal(1));
    TransactionDisplay t2 = new TransactionDisplay(1, "123",
            new BigDecimal("150"), "credit", new BigDecimal(1));
    TransactionDisplay t3 = new TransactionDisplay(1, "123",
            new BigDecimal("175"), "credit", new BigDecimal(1));
    List<TransactionDisplay> displayTransactions = new ArrayList<>();
    displayTransactions.add(t1);
    displayTransactions.add(t2);
    displayTransactions.add(t3);
    TransactionHistoryService tsh = new TransactionHistoryService();
    assertEquals("Highest Credit Amount: 175", tsh.findHighestTransactions(displayTransactions),
            "findHighestTransactions() not returning correct high credit amount message.");
  }

  @Test
  void findHighestTransactions_debitOnly() {
    TransactionDisplay t1 = new TransactionDisplay(1, "123",
            new BigDecimal("500"), "debit", new BigDecimal(1));
    TransactionDisplay t2 = new TransactionDisplay(1, "123",
            new BigDecimal("600"), "debit", new BigDecimal(1));
    TransactionDisplay t3 = new TransactionDisplay(1, "123",
            new BigDecimal("700"), "debit", new BigDecimal(1));
    List<TransactionDisplay> displayTransactions = new ArrayList<>();
    displayTransactions.add(t1);
    displayTransactions.add(t2);
    displayTransactions.add(t3);
    TransactionHistoryService tsh = new TransactionHistoryService();
    assertEquals("  Highest Debit Amount: 700", tsh.findHighestTransactions(displayTransactions),
            "findHighestTransactions() not returning correct high credit amount message.");
  }

  @Test
  void findHighestTransactions_creditAndDebit() {
    TransactionDisplay t1 = new TransactionDisplay(1, "123",
            new BigDecimal("174"), "debit", new BigDecimal(1));
    TransactionDisplay t2 = new TransactionDisplay(1, "123",
            new BigDecimal("163"), "credit", new BigDecimal(1));
    TransactionDisplay t3 = new TransactionDisplay(1, "123",
            new BigDecimal("215"), "debit", new BigDecimal(1));
    List<TransactionDisplay> displayTransactions = new ArrayList<>();
    displayTransactions.add(t1);
    displayTransactions.add(t2);
    displayTransactions.add(t3);
    TransactionHistoryService tsh = new TransactionHistoryService();
    assertEquals("Highest Credit Amount: 163  Highest Debit Amount: 215", tsh.findHighestTransactions(displayTransactions),
            "findHighestTransactions() not returning correct highest amount message.");
  }
}