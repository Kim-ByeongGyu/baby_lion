package com.exam.day07.server;

import java.util.List;

public class ChatHandler implements Runnable{
    private ClientManager clientManager;
    private ChatRoomManager chatRoomManager;
    private Client client;
    private ChatRoom chatRoom;  // null인 경우 - 로비

    public ChatHandler(ClientManager clientManager, ChatRoomManager chatRoomManager, Client client) {
        this.clientManager = clientManager;
        this.chatRoomManager = chatRoomManager;
        this.client = client;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = client.getIn().readLine();
                if (message == null) {
                    System.out.println(client.getNickname() + "닉네임 사용자가 연결을 끊었습니다.");
                    client.close();
                    return;
                }
                if (message.indexOf("/") == 0) {        // 0번 인덱스의 문자열이  "/"라면..
                    if ("/list".equals(message)) {
                        List<ChatRoom> chatRooms = chatRoomManager.getChatRooms();
                        for (ChatRoom chatRoom : chatRooms) {
                            client.getOut().println(chatRoom.getId());
                        }
                    } else if ("/create".equals(message)) {
                        // 방을 생성하고 생성된 방에 client를 입장시킴
                        chatRoom = chatRoomManager.createChatRoom();
                        // 채팅방 클라이언트 리스트에 클라이언트 추가.
                        chatRoom.addClient(client);
                        System.out.println("채팅방 " + chatRoom.getId() +"이(가) 생성되었습니다.");

                        client.getOut().println("채팅방이 생성되었습니다. 방번호 : " + chatRoom.getId());
                        chatRoom.broadcast(client.getNickname() + "님이 입장하였습니다.");
                    } else if (message.indexOf("/join") == 0) {
                        String[] tokens = message.split( " ", 2);
                        int chatRoomId = -1;
                        try {
                                chatRoomId = Integer.parseInt(tokens[1]);
                                chatRoom = chatRoomManager.getChatRoom(chatRoomId);
                                chatRoom.addClient(client);
                                chatRoom.broadcast(client.getNickname() + "님이 입장하였습니다.");
                        } catch (Exception e) {
                            client.getOut().println("잘못된 명령어!! :: /join [방 번호]");
                        }
                    } else if ("/exit".equals(message)) {
                        if (chatRoom != null) {
                            chatRoom.broadcast(client.getNickname() + "님이 퇴장하였습니다.");
                            chatRoom.removeClient(client);
                            chatRoom = null;
                        } else {
                            client.getOut().println("/exit은 채팅방 안에서만 쓸 수 있는 명령어 입니다.");
                        }
                    } else if ("/bye".equals(message)) {
                        if (chatRoom != null) {
                            chatRoom.broadcast(client.getNickname() + "님이 퇴장하였습니다.");
                            chatRoom.removeClient(client);
                        }
                        System.out.println(client.getNickname() + "닉네임의 시용자가 접속을 종료하였습니다.");
                        clientManager.removeClient(client);
                        client.close();
                        break;
                    }
                } else {
                    // 대화 입력
                    // 지정된 채팅룸이 없을 경우 대화 불가
                    if (chatRoom != null) {
                        // 대화방 입장한 상태
                        chatRoom.broadcast(client.getNickname() + ":" +  message);
                    } else {
                        System.out.println("채팅 방 안에 있지 않습니다!!");
                        client.getOut().println("채팅방 안에 없으므로 대화를 할 수 없습니다!!");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                client.close();
            }
        }
    }
}
