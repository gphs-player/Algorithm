## 栈队列相互实现

### 栈实现队列

#### 思路

需要借助辅助栈

栈A负责进栈

栈B负责出栈

进栈A   1，2，3

想出栈的时候，想出1咋办

将栈A的元素依次弹出，并压入栈B，则栈B的顺序是3，2，1

栈B出栈元素1

如果再有入栈元素，则进栈A

再有出栈，栈B继续弹栈，如果B是空栈，循环栈A弹栈到栈B的操作。

#### 代码

```java
private Stack<Integer> pushStack = new Stack<>();
private Stack<Integer> popStack = new Stack<>();

private void enQueue(int element){
    pushStack.push(element);
}

private Integer dequeue(){
    if (popStack.isEmpty()){
        if (pushStack.empty()){
            return null;
        }
        transfer();
    }
    return popStack.pop();
}

private void transfer() {
    while (!pushStack.empty()){
        popStack.push(pushStack.pop());
    }
}
```



### 队列实现栈

借助两个队列，轮流负责进栈和出栈操作，如：

A,B，C进入queue1,然后弹栈，出栈的应该是C，但是队列先进先出，所以将A,B进入queue2，把queue1的C弹出。再次弹栈的话应该是B出栈，将A进入queue1，把queue2的B出栈。