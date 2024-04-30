package com.exam.day06;

import java.io.FileOutputStream;

public class IOExam02 {
    public static void main(String[] args) {
        // 문자열을 파일에다가 출력하는 코드
        try (FileOutputStream fos = new FileOutputStream("output.txt");
        ) {
            int i;
            String output = "안녕하세요";
            fos.write(output.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
