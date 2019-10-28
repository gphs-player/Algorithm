## 栈实现队列

### 思路

需要借助辅助栈

栈A负责进栈

栈B负责进栈

进栈A   1，2，3

想出栈的时候，想出1咋办

将栈A的元素依次弹出，并压入栈B，则栈B的顺序是3，2，1

栈B出栈元素1

如果再有入栈元素，则进栈A

再有出栈，栈B继续弹栈，如果B是空栈，循环栈A弹栈到栈B的操作。

### 代码

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