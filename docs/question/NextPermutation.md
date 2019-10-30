## 数字全排列

给定数字，12345，求出该数字元素所有组合中下一个比它大的数值：12354



### 思路



### 代码

```java
public static void main(String [] args){
    int [] num = {1,2,3,4,5};
    for (int i = 0; i < 20; i++) {
         nextPermutation(num);
        output(num);
    }
}

private static void output(int [] num){
    for (int i : num) {
        System.out.print(i);
    }
    System.out.println();
}

private static void nextPermutation(int[] nums) {
    for(int i=nums.length-2;i>=0;i--){
        if(nums[i+1]>nums[i]){
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]>nums[i]){
                    swap(nums,i,j);
                    reverse(nums,i+1,nums.length-1);
                    return;
                }
            }
        }
    }
    reverse(nums,0,nums.length-1);
}
private static void swap(int[] nums,int left,int right){
    int tmp=nums[left];
    nums[left]=nums[right];
    nums[right]=tmp;
}
private static void reverse(int[] nums,int left,int right){
    while(left<right){
        int tmp=nums[left];
        nums[left]=nums[right];
        nums[right]=tmp;
        left++;
        right--;
    }
}
```