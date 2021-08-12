package com.ksmart.test.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo1 {
    /**
     * 1，求出 m个 真实值的平均值；
     * 2，求出 m个预测值与真实值的差的平方的和；
     * 3，求出 m个平均值与真实值的差的平方的和；
     * 4，求出第2与第3步结果的商；
     * 5，求出 1- 第4部的差得到R方
     * @param args
     */
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        map.put("1", 1.0);
        map.put("2", 2.0);

        Map<String, Double> mapYC = new HashMap<>();
        mapYC.put("1", 1.1);
        mapYC.put("2", 20.1);

        // 求真实值的平均值
        Double average = map.values().stream().mapToDouble(Double::new).average().getAsDouble();
        System.out.println("真实值的平均值:"+average);

        //求分子 预测值与真实值方差
        Double fenzi = map.entrySet().stream().map(x ->   mapYC.get(x.getKey())-x.getValue()).collect(Collectors.summingDouble(x -> x * x));
        System.out.println("分子:"+fenzi);

        //求分母 平均值与真实值方差
        Double fenmu = map.entrySet().stream().map(x ->  average-x.getValue() ).collect(Collectors.summingDouble(x -> x * x));
        System.out.println("分母:"+fenmu);

        // 求R方

        Double rf = 1 - fenzi / fenmu;

        System.out.println("方差:"+rf);

    }


}
