package com.example.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;

@Entity
@Table(name = "personModel")
public class AccountModel {
    @Id
    private String accNumber;

    @Column(name = "accountType")
    private String accountType;
    @Column(name = "accountName")
    private String accountName;
    @Column(name = "balance")
    private String balance;
    @Column(name = "date")
    private Calendar date;

    public AccountModel() {
    }

    public AccountModel(String accNumber, String accountType, String accountName, String balance, Calendar date) {
        this.accNumber = accNumber;
        this.accountType = accountType;
        this.accountName = accountName;
        this.balance = balance;
        this.date = date;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getBalance() {
        return balance;
    }

    public Calendar getDate() {
        return date;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}