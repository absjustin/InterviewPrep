package com.liuxin.interview.hard;

import java.util.HashMap;

public class LRUCache {
    int capacity;

    LinkedListNode head = null;

    LinkedListNode tail = null;

    HashMap<Integer, LinkedListNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

    public int get(int key) {
        LinkedListNode result = map.get(key);
        if (result == null) {
            return -1;
        } else {
            moveToHead(result);
            return result.value;
        }
    }

    public void put(int key, int value) {
        if (map.get(key) != null) {
            System.out.println("Duplicate put, moving key " + key + " to the front");
            moveToHead(map.get(key));
        } else {
            LinkedListNode newNode = new LinkedListNode(key, value);
            if (tail == null) {
                tail = newNode;
            }
            if (head == null) {
                head = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            if (map.size() < capacity) {
                System.out.println("Has room, adding key " + key);
                map.put(key, newNode);
                moveToHead(newNode);
            } else {
                System.out.println("Not enough room, evicting key " + tail.key + " then add key " + key);
                map.remove(tail.key);
                tail = tail.prev;
                tail.next.prev = null;
                tail.next = null;
                map.put(key, newNode);
                moveToHead(newNode);
            }
        }
    }

    private void moveToHead(LinkedListNode node) {
        if (node == head) {
            return;
        }
        if (tail == node) {
            tail = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
    }

    class LinkedListNode {
        public int key;
        public int value;
        public LinkedListNode next;
        public LinkedListNode prev;

        public LinkedListNode(int k, int v) {
            key = k;
            value = v;
        }
    }
}
