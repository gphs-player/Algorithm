package com.leo.cc.heap;

import com.sun.org.apache.regexp.internal.RE;
import org.omg.CORBA.Any;

public class BinaryHeap<AnyType extends Comparable<AnyType>> {

    private int currentSize;
    private static final int INIT_SIZE = 10;
    private AnyType[] array;

    public BinaryHeap() {
        this(INIT_SIZE);
    }

    public BinaryHeap(int init) {
        this.currentSize = 0;
        array = (AnyType[]) new Comparable[init + 1];
    }

    public BinaryHeap(AnyType[] items) {
        this.currentSize = items.length;
        this.array = (AnyType[]) new Comparable[(currentSize + 2) * 11 / 10];

        int i = 1;
        for (AnyType item : items) {
            array[i++] = item;
        }

        buildHeap();

    }


    public void insert(AnyType x) {
        if (currentSize == array.length - 1) {
            enlargeArray(array.length * 2 + 1);//扩容
        }
        int hole = ++currentSize;
        //依次遍历和父节点比较，找到合适的位置，并将父节点下沉
        for (array[0] = x; x.compareTo(array[hole / 2]) < 0; hole /= 2) {
            array[hole] = array[hole / 2];
        }
        array[hole] = x;//替换
    }

    private void enlargeArray(int newSize) {
        AnyType[] old = array;
        array = (AnyType[]) new Comparable[newSize];
        for (int i = 0; i < old.length; i++)
            array[i] = old[i];
    }


    public boolean isEmpty() {
        return currentSize == 0;
    }


    public AnyType deleteMin() {
        if (isEmpty()) throw new IllegalStateException("isEmpty");
        AnyType min = findMin();
        //将树底的最后一个元素升至第一位，然后下沉
        array[1] = array[currentSize - 1];
        percolateDown(1);
        return min;
    }


    private AnyType findMin() {
        if (isEmpty()) return null;
        return array[1];
    }


    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--)
            percolateDown(i);
    }

    /**
     * 1.将尾节点置于顶点，临时变量暂存
     * 2.遍历树，找到应该下沉的位置，在遍历过程中交换子节点的位置以便腾出空位
     * 3.将暂存的尾结点放置找到的位置
     */
    private void percolateDown(int hole) {
        int child;
        AnyType tmp = array[hole];
        //选取第一个下沉位置i
        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize &&
                    array[child + 1].compareTo(array[child]) < 0)
                //如果右子节点最小就定位到右边
                child++;
            if (array[child].compareTo(tmp) < 0)
                array[hole] = array[child];
            else
                break;
        }
        array[hole] = tmp;


    }


    public static void main(String[] args) {
        int numItems = 10000;
        BinaryHeap<Integer> h = new BinaryHeap<>( );
        int i = 37;

        for( i = 37; i != 0; i = ( i + 37 ) % numItems )
            h.insert( i );
        for( i = 1; i < numItems; i++ )
            if( h.deleteMin( ) != i )
                System.out.println( "Oops! " + i );
    }

}
