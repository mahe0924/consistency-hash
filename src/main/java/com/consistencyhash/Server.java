package com.consistencyhash;

import java.util.HashMap;
import java.util.Map;

public class Server {
    private String name;
    private Map<Entry,Entry> entries;

    Server(String name){
        this.name = name;
        entries = new HashMap<>();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public void put(Entry e){
        entries.put(e,e);
    }
    public Entry get(Entry e){
        return entries.get(e);
    }
}
