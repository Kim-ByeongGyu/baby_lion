package com.exam.day01;

import java.util.Scanner;

public class Exam03 {
    // 학생 수 입력
    // 학생 수에 따른 점수 입력
    // 모든 학생 점수 출력
    // 전체 학생의 총점과 평균 출력
    static Scanner sc = new Scanner(System.in);

    static int 학생수 () {
        System.out.println("학생 수를 입력하세요.");
        int num = sc.nextInt();
        return num;
    }
//    static int[] 점수 (int num) {
//        for (int i = 0; i < num; i++) {
//
//            int[i] = sc.nextInt();
//        }
//        return int[];
//    }

    public static void main(String[] args) {
        int num = 학생수();
        int sum = 0;
        int avg = 0;
        int[] score = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.printf("학생 %d의 점수를 입력하세요.",i+1);
            score[i]= sc.nextInt();
            sum += score[i];
        }
        avg = sum/num;

        System.out.print("|");
        for (int i = 0; i < num; i++) {
            System.out.printf("\t학생%d : %d\t|",i+1,score[i]);
        }
        System.out.println();
        System.out.println("점수 합계 : " + sum);
        System.out.println("점수 평균 : " + avg);

    }
}
