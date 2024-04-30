package com.exam.day07.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        // 객체가 한개만 생성되어야한다,
        ClientManager clientManager = new ClientManager();
        ChatRoomManager chatRoomManager = new ChatRoomManager();
        try (ServerSocket serverSocket = new ServerSocket(12345);
        ) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println(socket.getInetAddress() + " client가 접속했습니다.");

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String nickname = in.readLine();
                System.out.println(nickname + "닉네임의 사용자가 연결되었습니다.");

                Client client = new Client(nickname, in, out, socket);
                clientManager.addClient(client);

                // 사용법
                out.println(nickname + "님 접속을 환영합니다.");
//                help();
                out.println("사용방법");
                out.println("...");

                new Thread(new ChatHandler(clientManager, chatRoomManager, client)).start();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void help() {
        System.out.println("명령어 모음" +
                "/help : 명령어 모음" +
                "/create [방이름] : 방 생성");
    }
}
