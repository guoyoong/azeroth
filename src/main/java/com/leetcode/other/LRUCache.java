package com.leetcode.other;
/**
 * Created by guoyong1 on 2017/8/28.
 */

import org.junit.Test;

import java.util.HashMap;

public class LRUCache {
    private int MAX_CACHE_SIZE = 1024;
    private Entry<Integer, Integer> first;
    private Entry<Integer, Integer> last;

    private HashMap<Integer, Entry<Integer, Integer>> hashMap;

    public LRUCache(int capacity) {
        MAX_CACHE_SIZE = capacity;
        hashMap = new HashMap<>();
    }

    public int get(int key) {
        Entry<Integer, Integer> entry = getEntry(key);
        if (entry == null)
            return -1;
        moveToFirst(entry);
        return entry.value;
    }

    public void remove(Integer key) {
        Entry<Integer, Integer> entry = getEntry(key);
        if (entry != null) {
            if (entry.pre != null)//前序节点
                entry.pre.next = entry.next;
            if (entry.next != null)//后续节点
                entry.next.pre = entry.pre;
            if (entry == first)
                first = entry.next;
            if (entry == last)
                last = entry.pre;
        }
        hashMap.remove(key);
    }

    private void moveToFirst(Entry<Integer, Integer> entry) {
        if (entry == first)
            return;
        if (entry.pre != null)
            entry.pre.next = entry.next;
        if (entry.next != null)
            entry.next.pre = entry.pre;
        if (entry == last)
            last = last.pre;

        if (first == null || last == null) {
            first = last = entry;
            return;
        }

        entry.next = first;
        first.pre = entry;
        first = entry;
        entry.pre = null;
    }

    private void removeLast() {
        if (last != null) {
            last = last.pre;
            if (last == null) first = null;
            else
                last.next = null;
        }
    }


    private Entry<Integer, Integer> getEntry(Integer key) {
        return hashMap.get(key);
    }


    public void set(int key, int value) {
        Entry<Integer, Integer> entry = getEntry(key);
        if (entry == null) {
            if (hashMap.size() >= MAX_CACHE_SIZE) {
                hashMap.remove(last.key);
                removeLast();
            }
            entry = new Entry<>();
            entry.key = key;
        }
        entry.value = value;
        moveToFirst(entry);
        hashMap.put(key, entry);
    }

    class Entry<K, V> {
        public Entry<K, V> pre;
        public Entry<K, V> next;
        public K key;
        public V value;
    }

    @Test
    public void test(){
        LRUCache lru = new LRUCache(3);
        lru.set(1, 1);
        lru.set(2, 2);
        lru.remove(1);

    }
}
