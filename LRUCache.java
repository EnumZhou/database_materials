package com.mercury.algorithm;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRUCache {
    private final int CACHE_SIZE;
    private LinkedHashMap<Object,Object> lhm;

    LRUCache(int capacity){
        this.CACHE_SIZE=capacity;
        this.lhm = new LinkedHashMap<>();
    }

    public void add(Object key,Object value){
        lhm.putIfAbsent(key,value);
        if(lhm.containsKey(key)){
            if(lhm.size()==CACHE_SIZE){
                Object firstKey= lhm.entrySet().stream().findFirst();
                lhm.remove(firstKey);

            }
            // move to the end, end always be the recently used;
            lhm.remove(key);
            lhm.put(key,value);
        }

    }
}
