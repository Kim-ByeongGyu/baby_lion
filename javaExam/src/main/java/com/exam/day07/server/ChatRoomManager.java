package com.exam.day07.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChatRoomManager {
    private static int idGenerator = 1;
    private Map<Integer, ChatRoom> chatRoomMap = new ConcurrentHashMap<>();

    public ChatRoom createChatRoom() {
        ChatRoom chatRoom = new ChatRoom(idGenerator++);
        chatRoomMap.put(chatRoom.getId(), chatRoom);

        return chatRoom;
    }

    public void removeRoom(int id) {
        chatRoomMap.remove(id);
    }

    public ChatRoom getChatRoom(int id) {
        return chatRoomMap.get(id);
    }

    public List<ChatRoom> getChatRooms() {
        return new ArrayList<>(chatRoomMap.values());
    }
}
