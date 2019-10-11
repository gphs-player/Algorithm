package com.leo;

import java.util.HashMap;
import java.util.Map;

public class Find {

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 4, 8, 7, 2};

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i : arr) {
            Integer integer = hashMap.get(i);
            if (integer == null) {
                hashMap.put(i, 1);
            } else {
                hashMap.put(i, ++integer);
            }
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer value = entry.getValue();
            Integer key = entry.getKey();
            System.out.println(key + " : " + value);
        }
    }


}
