package com.exam.day07.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatRoom {
    private int id;
    private List<Client> clients = Collections.synchronizedList(new ArrayList<>());

    public ChatRoom(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void  removeClient(Client client) {
        clients.remove(client);
    }

    public void broadcast(String message) {
        for (Client client : clients) {
            client.getOut().println(message);
        }
    }
}
