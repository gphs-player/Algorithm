package com.leo.algorithm.question;

/**
 * 两个大数相加，超出LONG的范围的那种
 */
public class AddTwoNum {

    public static void main(String [] args){

        String result = bigNumSum("426709752318", "95481253129");
        System.out.println(result);
    }

    private static String bigNumSum(String bigNumA,String bigNumB){
        //1.把两个大整数用数组逆序存储，数组长度等于较大整数位数+1
        int maxLength = bigNumA.length() > bigNumB.length() ?bigNumA.length():bigNumB.length();
        int[] arrayA = new int[maxLength + 1];
        for (int i = 0; i < bigNumA.length(); i++) {
            //逆序存储
            arrayA[i] = bigNumA.charAt(bigNumA.length() -1 - i) - '0';
        }

        int[] arrayB = new int[maxLength + 1];
        for (int i = 0; i < bigNumB.length(); i++) {
            arrayB[i] = bigNumB.charAt(bigNumB.length() -1 - i) - '0';
        }


        //2.构建result数组，长度也是一样的
        int [] result = new int[maxLength+1];
        //3.遍历数组，按位相加
        for (int i = 0; i < result.length; i++) {
            int temp = result[i];
            temp += arrayA[i];
            temp += arrayB[i];
            if (temp > 10){
                temp = temp -10;
                result[i+1] = 1;
            }
            result[i] = temp;
        }
        //4.把result数组再次逆序并转成String
        StringBuilder sb = new StringBuilder();
        boolean findFirst = false;
        for (int i = result.length - 1; i >= 0 ; i--) {
            if (!findFirst){
                if (result[i] == 0){
                    continue;
                }
                findFirst = true;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
