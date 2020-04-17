## 最小栈

​	实现一个栈，带有出栈(pop)、入栈(push)、获取最小元素(getMin)的方法，保证时间复杂度是O(1)



### 思路A

​	创建两个栈，栈A和栈B，当第一个元素进栈A的时候，也让元素进栈B,唯一的元素就是最小元素。每次有新元素入栈的时候，比较新元素和栈A中最小元素的大小，如果小于栈A的最小元素，让新元素进栈B，栈B的栈顶元素就是栈A的当前最小值。

​	每当栈A有元素出栈的时候，如果是栈A的最小值，则栈B的栈顶也出栈，此时栈B的栈顶元素就是栈A的最小值（原先的第二小）。

​	调用getMin方法，返回栈B的栈顶，也是栈A的最小值。

### 代码

```java
private Stack<Integer> mainStack = new Stack<>();
private Stack<Integer> minStack = new Stack<>();

public void push(int element){
  	mainStack.push(elemeng);
  	if(minStack.isEmpty() || element <= minStack.peek()){
      	minStack.push(element);
    }
}
public Integer pop(){
  	if(mainStack.peek().equals(minStack.peek())){
      	minStack.pop();
    }
  	return mainStack.pop();
}

public Integer getMin(){
  	return minStack.peek();
}

MinStack stack = new MinStack();
stack.push(4);
stack.push(9);
stack.push(7);
stack.push(3);
stack.push(8);
stack.push(5);

System.out.println(stack.getMin());//获取到最小值
stack.pop();
stack.pop();
stack.pop();//依次将 5，8，3出栈，4才是最小值
System.out.println(stack.getMin())；//有元素出栈之后，获取第二小
```



### 思路B

上面的思路借助到了辅助栈，如果只用一个栈？

[leetcode参考](https://leetcode-cn.com/problems/min-stack/comments/)