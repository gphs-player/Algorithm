package com.leo.structure.queue;

import java.util.Arrays;

/**
 * 优先队列
 * 出入队操作
 * 最大堆的示例
 */
public class PriorityQueue {
    public static void main(String [] args) throws Exception {
        PriorityQueue queue = new PriorityQueue();
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(2);
        queue.enqueue(7);
        queue.enqueue(8);
        System.out.println("出队元素 ："+queue.dequeue());
        System.out.println("出队元素 ："+queue.dequeue());

    }

    private int size;
    private int [] arr;

    public PriorityQueue() {
        this.arr = new int[32];
    }


    public void enqueue(int element){
        if (size > arr.length){
            resize();
        }
        arr[size++] = element;
        upAdjust();

    }

    public int dequeue() throws Exception {
        if (size < 0){
            throw new Exception("queue is empty");
        }
        int top = arr[0];
        arr[0] = arr[--size];//最后一个元素到堆顶
        downAdjust();
        return top;
    }

    /**
     * 下沉
     */
    private void downAdjust() {
        int parentIndex = 0;
        int temp = arr[parentIndex];
        int childIndex = 1;
        while (childIndex < size){
            //如果有右孩子且大于左孩子，就定位到右孩子
            if (childIndex +1 <size && arr[childIndex +1] > arr[childIndex ]){
                childIndex ++;
            }
            //父节点大于子节点，跳出
            if (temp >= arr[childIndex]){
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex * 2 + 1;
        }
        arr[parentIndex] = temp;
    }

    /**
     * 上浮
     */
    private void upAdjust() {
        int child = arr[size - 1];
        int parent = (child - 1) / 2;
        int temp = arr[child];
        while (child > 0 && temp > arr[parent]){
            //互换父子位置
            arr[child] = arr[parent];
            child = parent;
            parent = parent /2;
        }
        //找到合适位置，新元素赋值
        arr[child] = temp;
    }

    //扩容
    private void resize() {
        arr = Arrays.copyOf(arr,arr.length * 2);
    }
}
