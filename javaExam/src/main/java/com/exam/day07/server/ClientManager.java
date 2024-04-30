package com.exam.day07.server;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ClientManager {
    // 1. 배열 > 고정길이..
    // 2. List<Client> > 적합..(중복 허용) > 검색 - 다 뒤저야할 수도..
    // 3. Set<Client> > (중복x..?)
    // 4. Map<k, v> > key값을 이용해 값을 한번에 찾을 수 있다. - nockname을 key로..
    private Map<String, Client> clientMap = new ConcurrentHashMap<>();
    // Concurrent가 붙어 있으면 이미 동기화가 적용되있음.

    public void addClient(Client client) {
        clientMap.put(client.getNickname(), client);
    }

    public void removeClient(Client client) {
        clientMap.remove(client.getNickname());
    }
}
