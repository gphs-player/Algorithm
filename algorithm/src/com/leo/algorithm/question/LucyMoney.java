package com.leo.algorithm.question;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LucyMoney {
    public static void main(String [] args){
        List<Integer> divide = divideMoney(1000, 10);
        double result = 0;
        for (Integer integer : divide) {
            System.out.println("分割："+integer);
            BigDecimal resultItem = new BigDecimal(integer).divide(new BigDecimal(100));
            System.out.println(resultItem);
            result += resultItem.doubleValue();
        }
        System.out.println(result);
    }

    //二倍均值法
    //每次抢到的金额=随机区间[0.01,m/n*2-0.01];
    //假设5个人抢100元
    //第一个人： 100/5 * 2 = 40  正常情况  均值范围是20元
    //第一个人： 80/4 * 2 = 40   平均也是20元
    private static List<Integer> divideMoney(int totalMoney, int people) {
        List<Integer> amountList = new ArrayList<>();
        int restMoney = totalMoney;
        int restPeople = people;

        Random random = new Random();
        for (int i = 0; i < people; i++) {
            int amount = random.nextInt(restMoney / restPeople * 2 - 1) + 1;
            restMoney -= amount;
            restPeople--;
            amountList.add(amount);
        }
        return amountList;
    }
}
