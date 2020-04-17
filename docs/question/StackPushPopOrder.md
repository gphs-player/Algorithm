### 栈的压入弹出顺序
给定一个栈的压入顺序数列，判断某个数列是不是该亚栈序列的弹出顺序

比如[1,2,3,4,5]是一个栈的压入顺序，那么[4,5,3,2,1]就是一个对应的弹出顺序，而[4,3,5,1,2]就不是一个弹出顺序。

#### 思路

借助一个辅助栈，先看弹出序列[4,5,3,2,1]第一个弹出的元素是4，那么4就需要在栈里面，但是因为序列的压入顺序已经确定了，所以1，2，3需要提前进栈，那么栈里的元素就是[1，2，3，4],这个时候4就可以出栈了，接下来是元素5进栈然后弹出，此时栈里剩下的就是[1，2，3],依次弹出，符合给定的弹出序列。

再分析[4,3,5,1,2]的弹出序列。和刚才的情况一样，4首先被弹出，那么1，2，3，4都要进栈，然后弹出4和3，接下来5进栈弹出，此时栈里还剩[1,2]，要求弹出的的数字是1，但是入栈元素已经没有，栈里弹出的只能是2，1，所以不满足弹出序列。



#### 代码

```java
public class StackOrder {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int order1[] = {4, 5, 3, 2, 1};//true
        int order2[] = {4, 2, 5, 1, 3};//false
        int order3[] = {3, 5, 4, 2, 1};//true
        boolean isCorrectOrder = check(arr, order3);
        System.out.println(isCorrectOrder);
    }
    private static boolean check(int[] arr, int[] order1) {
        Stack<Integer> stack = new Stack<>();
        int indexPush = 0;
        int indexPop = 0;
        while (indexPop < order1.length) {
            while (stack.isEmpty() || stack.peek() != order1[indexPop]){
                if (indexPush >= order1.length ) {
                    break;
                }
                stack.push(arr[indexPush]);
                indexPush++;
            }
            if (stack.peek() != order1[indexPop]) {
                break;
            }
            stack.pop();
            indexPop++;
        }
        if (stack.isEmpty() && indexPop == order1.length) {
            return true;
        }
        return false;
    }
}
```