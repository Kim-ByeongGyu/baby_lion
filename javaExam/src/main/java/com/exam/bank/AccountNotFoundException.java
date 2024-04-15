package com.exam.bank;

public class AccountNotFoundException extends Exception{
    public AccountNotFoundException(String msg) {
        super(msg);
    }
}
