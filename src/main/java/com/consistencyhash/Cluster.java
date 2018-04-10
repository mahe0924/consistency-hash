package com.consistencyhash;

import java.util.SortedMap;
import java.util.TreeMap;

public class Cluster {

    private static final int SERVER_SIZE_MAX = 1024;
    private SortedMap<Integer, Server> servers = new TreeMap<Integer, Server>();
    private int size = 0;

    public boolean addServer(Server server){
        if (size >= SERVER_SIZE_MAX){
            return false;
        }
        servers.put(server.hashCode(),server);
        return true;
    }

    public Server routeServer(int hash){
        if (servers.isEmpty()){
            return null;
        }
        if (!servers.containsKey(hash)){
            SortedMap<Integer,Server> tailMap = servers.tailMap(hash);
            hash = tailMap.isEmpty() ? servers.firstKey() : tailMap.firstKey();
        }
        return servers.get(hash);
    }

    public void put(Entry e){
        routeServer(e.hashCode()).put(e);
    }

    public Entry get(Entry e){
        return routeServer(e.hashCode()).get(e);
    }

    public Server getServer(Entry e){
        return routeServer(e.hashCode());
    }
}
