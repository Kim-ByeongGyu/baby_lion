package com.exam.day01;

import java.util.Scanner;

public class Exam02 {
    //정수1개와 문자 1개를 입력받아서 예를 들어 3과 *을 입력받았다면,
    /*
    ***
    ***
    ***
    */
    //5,#
    /*
    #####
    #####
    #####
    #####
    #####
    처럼 출력하는 메소드 만들기*/

    private static void 출력(int num, String str) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(str);
            }
            System.out.println();
        }
    }
    static int 숫자 () {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하세요");
        int num = sc.nextInt();
        return num;
    }
    static String 문자 () {
        Scanner sc = new Scanner(System.in);
        System.out.println("문자를 입력하세요");
        String str = sc.next();
        return str;
    }
    public static void main(String[] args) {
        출력(숫자(),문자());
    }
}
