package com.leo.cc;

import sun.security.provider.SHA;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 泛型
 */

public class GenericType {

    public static void main(String[] args) {

        Shape[] shapes = {new Shape(), new Shape()};
        Shape[] squares = {new Square(), new Square()};
        //编译运行正常的，数组是协变的
        System.out.println(totalArea(shapes));
        System.out.println(totalArea(squares));


        List<Square> shapeList = new ArrayList<>();
        shapeList.add(new Square());
        shapeList.add(new Square());
        shapeList.add(new Square());
        System.out.println(totalArea(shapeList));

        System.out.println();
        System.out.println(contains(shapes, ""));
        System.out.println();
        System.out.println(findMax(shapes));
    }

    public static double totalArea(Shape[] arr) {
        double total = 0;
        for (Shape shape : arr) {
            if (shape != null) {
                total += shape.area();
            }
        }

        return total;
    }

    //能否编译在于shapeList是哪种类型，如果它的泛型指定为Shape，就能编译运行，否则不可以
//    public static double totalArea(Collection<Shape> arr) {
    //参数的泛型可以是Shape及其子类
    public static double totalArea(Collection<? extends Shape> arr) {
        double total = 0;
        for (Shape shape : arr) {
            if (shape != null) {
                total += shape.area();
            }
        }

        return total;
    }

    //在某个类型列表中查找是否包含某个元素
    public static <AnyType> boolean contains(AnyType[] arr, AnyType x) {
//        System.out.println(x.getClass().isAssignableFrom(arr[0].getClass()));
        for (AnyType val : arr) {
            if (val.equals(x)) {
                return true;
            }
        }
        return false;
    }


    public static <AnyType extends Comparable<? super AnyType>> AnyType findMax(AnyType[] arr) {
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(arr[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }


}

class Shape implements Comparable{

    public double area() {
        return 0.1;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

class Square extends Shape {
    @Override
    public double area() {
        return 0.4;
    }
}
