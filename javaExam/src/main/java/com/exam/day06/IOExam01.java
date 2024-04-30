package com.exam.day06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOExam01 {
    public static void main(String[] args) {
        // 파일로부터 읽어와서 콘솔에 출력하는 코드
        try (FileInputStream fis = new FileInputStream("ioexam.txt");
        ) {
            int i;
            int count = 0;
//            while ((i = fis.read()) != -1) {
//                count++;
//                System.out.print((char) i);
//            }

            byte[] b = new byte[512];
            while ((i = fis.read(b)) != -1) {
                count++;
                String s = new String(b, 0, i);
                System.out.println(s);
            }
            System.out.println("\n총 " + count + "회 읽어왔습니다.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("입력받는 도중 예외가 발생했습니다.");
        }/* finally {
            if (fis != null) {
                fis.close();
            }
        }*/
    }
}
