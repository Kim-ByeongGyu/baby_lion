package com.exam.bank;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    // 입금, 출금 --- 통장
    // 비밀번호 --- 통장
    // 고객정보 --- 고객
    private String name;
    private String customerId;

    // 통장 리스트
    List<Account> accounts = new ArrayList<>();

    // 정보입력을 위한 생성자

    public Customer(String name, String customerId, List<Account> accounts) {
        this.name = name;
        this.customerId = customerId;
        this.accounts = accounts;
    }

    public Customer(String customerId) {
        this.customerId = customerId;
    }
    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }
// 필요한 메서드들 구현
}
