package com.exam.day02;

import java.util.Scanner;

public class MonthChecker {
    public static void monthCheck (int month) {
        switch (month) {
            case 1 :
                System.out.println("1월입니다.");
                break;
            case 2 :
                System.out.println("2월입니다.");
                break;
            case 3 :
                System.out.println("3월입니다.");
                break;
            case 4 :
                System.out.println("4월입니다.");
                break;
            case 5 :
                System.out.println("5월입니다.");
                break;
            case 6 :
                System.out.println("6월입니다.");
                break;
            case 7 :
                System.out.println("7월입니다.");
                break;
            case 8 :
                System.out.println("8월입니다.");
                break;
            case 9 :
                System.out.println("9월입니다.");
                break;
            case 10 :
                System.out.println("10월입니다.");
                break;
            case 11 :
                System.out.println("11월입니다.");
                break;
            case 12 :
                System.out.println("12월입니다.");
                break;
            default:
                System.out.println("1~12사이의 정수가 아닙니다.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int month;
        
        do {
            System.out.print("월을 입력하세요 (1~12): ");
            month = sc.nextInt();
            if (month < 1 || month > 12) {
                System.out.println("1~12 사이의 정수가 아닙니다.");
            } else {
                monthCheck(month);
            }
        } while (month < 1 || month > 12);

    }
}
