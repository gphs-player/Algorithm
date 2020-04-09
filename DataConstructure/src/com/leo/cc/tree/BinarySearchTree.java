package com.leo.cc.tree;

import org.omg.CORBA.Any;

import java.util.Comparator;

public class BinarySearchTree<AnyType extends Comparable<AnyType>> {


    private BinaryNode<AnyType> mRoot;

    private Comparator<? super AnyType> cmp;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<? super AnyType> c) {
        this.mRoot = null;
        this.cmp = c;
    }

    private int myCompare(AnyType lhs, AnyType rhs) {
        if (cmp != null) {
            return cmp.compare(lhs, rhs);
        } else {
            return lhs.compareTo(rhs);
        }
    }

    public void makeEmpty() {
        mRoot = null;
    }

    public boolean isEmpty() {
        return mRoot == null;
    }

    //是否包含
    public boolean contains(AnyType x) {
        return contains(x, mRoot);
    }

    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) return false;

        int compare = myCompare(x, t.element);
        if (compare < 0) {
            return contains(x, t.left);
        } else if (compare > 0) {
            return contains(x, t.right);

        } else {
            return true;
        }
    }


    public BinaryNode<AnyType> findMin() {
        if (isEmpty()) throw new IllegalStateException("isEmpty");
        return (BinaryNode<AnyType>) findMin(mRoot).element;
    }

    /**
     * 递归调用
     *
     * @param root
     * @return
     */
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> root) {
        if (root == null) return null;
        else if (root.left == null) {
            return root;
        }
        return findMin(root.left);
    }


    public BinaryNode<AnyType> findMax() {
        if (isEmpty()) throw new IllegalStateException("isEmpty");
        return (BinaryNode<AnyType>) findMax(mRoot).element;
    }


    /**
     * 非递归调用
     *
     * @param root
     * @return
     */
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> root) {
        if (root != null) {
            while (root.right != null) {
                root = root.right;
            }
        }
        return root;
    }

    public void insert(AnyType x) {
        mRoot = insert(x, mRoot);
    }

    /**
     * 插入操作会影响树的结构
     */
    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> root) {
        if (root == null)
            return new BinaryNode<AnyType>(x);

        int compareResult = x.compareTo(root.element);
        if (compareResult < 0) {
            root.left = insert(x, root.left);
        } else if (compareResult > 0) {
            root.right = insert(x, root.right);
        } else {
            //重复元素，不做操作
        }
        return root;
    }

    public void remove(AnyType x) {
        mRoot = insert(x, mRoot);
    }

    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> root) {
        //没有结点就直接返回
        if (root == null) return root;
        //递归去寻找匹配的结点
        int compare = x.compareTo(root.element);
        if (compare < 0) {
            root.left = remove(x, root.left);
        } else if (compare > 0) {
            root.right = remove(x, root.right);
        }


        //找到的结点是有子节点的

        //两个子节点
        else if (root.left != null && root.right != null) {
            root.element = findMin(root.right).element;
            root.right = remove(root.element,root.right);
        }
        //一个子节点
        else {
            root = root.left != null ? root.left : root.right;
        }
        return root;
    }


    static class BinaryNode<AnyType> {
        public BinaryNode(AnyType element) {
            this(element, null, null);
        }

        public BinaryNode(AnyType element, BinaryNode left, BinaryNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
    }
}
