package com.leo.structure.array;

/**
 *
 * 数组的存放是连续的空间
 * 数组的插入操作
 *
 *扩容时间复杂度O(n)
 * 插入移动时间复杂度O(n)
 * 删除时间复杂度O(n)
 */
public class MyArray {


    private int[] array;
    private int size;


    public MyArray(int capacity) {
        this.array = new int[capacity];
        size = 0;

    }

    public void insert(int element, int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("超出数组实际范围");
        }
        for (int i = size -1; i >= index; i --){
            array[i+1] = array[i];
        }
        array[index] = element;
        size++;
        System.out.println("current size : "+size);
    }


    public void output(){
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }


    public static void main(String [] args){

        MyArray myArray = new MyArray(10);
        myArray.insert(3,0);
        myArray.insert(7,1);
        myArray.insert(9,2);
        myArray.insert(5,3);
        myArray.insert(6,1);
        myArray.output();

    }
}
