package com.leo.algorithm;


public class BitMap {
    //保存数据的
    private byte[] bits;

    //能够存储多少数据
    private int capacity;


    public BitMap(int capacity) {
        this.capacity = capacity;
        //1byte能存储8个数据，那么capacity数据需要多少个byte呢，capacity/8+1,右移3位相当于除以8
        bits = new byte[(this.capacity >> 3) + 1];
    }

    private void add(int element) {
        //找到数据存放的位置
        int index = element / 8;
        int position = element % 8;
        bits[index] |= 1 << position;
    }

    private void clear(int element) {
        int index = element / 8;
        int position = element % 8;
        bits[index] &= ~(1 << position);
    }

    private boolean contain(int element) {
        int index = element / 8;
        int position = element % 8;
        return (bits[index] & (1 << position)) != 0;

    }

    public static void main(String[] args) {
        BitMap bitmap = new BitMap(100);
        bitmap.add(7);
        System.out.println("插入7成功");

        boolean isexsit = bitmap.contain(7);
        System.out.println("7是否存在:" + isexsit);

        bitmap.clear(7);
        isexsit = bitmap.contain(7);
        System.out.println("7是否存在:" + isexsit);
    }
}
