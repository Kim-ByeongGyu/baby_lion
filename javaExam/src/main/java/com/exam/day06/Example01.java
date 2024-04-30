package com.exam.day06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Example01 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
             PrintWriter pw = new PrintWriter("input.txt");
        ) {
            String str;
            System.out.println("저장할 내용 입력 (exit을 입력하면 끝내기)");
            while (!"exit".equalsIgnoreCase((str = br.readLine()))) {
                System.out.println(str + "\n");
                pw.write(str + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
