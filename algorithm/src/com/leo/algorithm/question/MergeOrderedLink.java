package com.leo.algorithm.question;


import static com.leo.algorithm.question.DeleteLinkedNode.LinkedNode;

public class MergeOrderedLink {
    public static void main(String[] args) {

        LinkedNode odd = new LinkedNode(1);
        odd.next = new LinkedNode(3);
        odd.next.next = new LinkedNode(5);
        odd.next.next.next = new LinkedNode(7);

        LinkedNode even = new LinkedNode(2);
        even.next = new LinkedNode(4);
        even.next.next = new LinkedNode(6);
        even.next.next.next = new LinkedNode(8);
        LinkedNode merge = merge(odd, even);
        while (merge!=null){
            System.out.println(merge.value);
            merge = merge.next;
        }


    }

    private static LinkedNode merge(LinkedNode odd, LinkedNode even) {
        if (odd == null) return even;
        if (even == null) return odd;
        LinkedNode newLink;
        if (odd.value < even.value){
            newLink = new LinkedNode(odd.value);
            newLink.next = merge(odd.next,even);
        }else {
            newLink = new LinkedNode(even.value);
            newLink.next = merge(odd,even.next);
        }
        return newLink;
    }
}
