package com.example.account.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "accountModel")
public class AccountModel {
    @Id
    @GeneratedValue
    private long accNumber;

    @Column(name = "accountType")
    private String accountType;
    @Column(name = "accountName")
    private String accountName;
    @Column(name = "balance")
    private String balance;
    @Temporal(TemporalType.DATE)
    private Calendar date = Calendar.getInstance();

    public AccountModel() {
    }

    public AccountModel(long accNumber, String accountType, String accountName, String balance, Calendar date) {
        this.accNumber = accNumber;
        this.accountType = accountType;
        this.accountName = accountName;
        this.balance = balance;
        this.date = date;
    }

    public long getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(long accNumber) {
        this.accNumber = accNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}