package com.exam.bank;

public class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String msg) {
        super(msg);
    }
}
