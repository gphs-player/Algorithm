package com.leo.algorithm;

import java.util.HashMap;

/**
 * LRU算法实现
 */
public class LruAlgo {


    public static void main(String [] args){
        LruAlgo lruCache = new LruAlgo(5);
        lruCache.put("001","用户1");
        lruCache.put("002","用户2");
        lruCache.put("003","用户3");
        lruCache.put("004","用户4");
        lruCache.put("005","用户5");
        String msg002 = lruCache.get("002");
        System.out.println(msg002);
        lruCache.put("004","用户4信息更新");
        lruCache.put("006","用户6信息更新");
        System.out.println(lruCache.get("001"));
        System.out.println(lruCache.get("006"));
        System.out.println(lruCache.get("002"));
        System.out.println(lruCache.get("004"));
    }

    private Node head;
    private Node end;

    private int limit;

    private HashMap<String, Node> hashMap;

    public LruAlgo(int limit) {
        this.limit = limit;
        hashMap = new HashMap<>();
    }

    public String get(String key) {
        Node node = hashMap.get(key);
        if (node == null) return null;
        refreshNode(node);
        return node.value;
    }

    public void put(String key, String value) {
        Node node = hashMap.get(key);
        if (node == null) {
            //找不到就插入
            if (hashMap.size() >= limit) {
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node(key, value);
            addNode(node);
            hashMap.put(key, node);
        } else {
            node.value = value;
            refreshNode(node);
        }
    }

    private void addNode(Node node) {

        if (end != null){
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if (head == null){
            head = node;
        }
    }

    private void remove(String key) {
        Node node = hashMap.get(key);
        refreshNode(node);
        hashMap.remove(key);
    }


    private String removeNode(Node node) {
        if (node == head && node == end) {
            //remove the last node
            head = null;
            end = null;
        } else if (node == end) {
            end = end.pre;
            end.next = null;
        } else if (node == head) {
            head = head.next;
            head.pre = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }


    private void refreshNode(Node node) {

        if (node == end) {
            return;
        }
        removeNode(node);
        addNode(node);

    }


    static class Node {
        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        Node pre;
        Node next;
        String key;
        String value;
    }
}
