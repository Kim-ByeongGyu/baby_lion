package com.exam.bank;

public class Account {
    // 잔액
    // 고객ID
    // 비밀번호
    private int money;
    private String customerId;
    private int password;

    public Account(String customerId, int password) {
        this.customerId = customerId;
        this.password = password;
        money = 0;
    }

    // 입금하기
    void 입금(int money) {
         this.money += money;
        System.out.println(this.money);
    }
    // 출금하기
    void 출금(int money) {
        try {
            if (this.money < money) {
                throw new InsufficientFundsException("잔액이 부족합니다");
            } else {
                this.money -= money;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 잔액 확인하기
    void 잔액() {
        System.out.println(money);
    }

    // 원하는 필드, 메서드, 생성자 구현

}
