package com.exam.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;    //은행명
    private List<Customer> customers = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
//    private Customer[] customers = new Customer[10];
//    private Account[] accounts = new Account[50];

    // 은행이 기본으로 가질 초기 데이터를 입력하는 코드 추가
    Bank(String name, List<Customer> customers, List<Account> accounts) {
        customers.add(new Customer("이름01", "ID01", new ArrayList<>()));
        this.name = name;
        this.customers = customers;
        this.accounts = accounts;
    }

    // open 은행이 열 때 해야하는 작업이 있다면...
    private void open() {

    }

    // close 은행이 닫을 때 해야하는 작업이 있다면...
    private void close() {

    }

    private void 개설(String customerId, String name, int password) {
        Account account;

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).equals(customerId)) {
                account  = new Account(customerId, password);
                Customer customer = new Customer(name, customerId);
                customer.accounts.add(account);
            }
        }
    }

}
