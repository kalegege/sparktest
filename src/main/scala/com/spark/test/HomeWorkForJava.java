package com.spark.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kale on 2017/7/17.
 */
public class HomeWorkForJava {
    public static void main(String[] args) {
        List<Integer> list = createArrayList(1, 2, 4, -8, 99, -98, -5, 23, 0, -4);
        List<Integer> list2 = clearFushu(list);
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }

        System.out.println(sumcube(1, 2));

    }
    //立方
    public static int cube(int x) {return x * x * x;}
    //平方
    public static int square(int x) {return x * x ;}
    //自身
    public static int id(int x) {return x ;}
    //阶乘
    public static int fact(int x) {return x == 0 ? 1 : x*fact(x-1);}
    //a-b之间的和
    public static int sumInt(int a,int b) {return a > b ? 0 : sumInt(a + 1, b) + id(a);}
    //a-b之间的平方和
    public static int sumSquare(int a,int b) {return a > b ? 0 : sumSquare(a + 1, b) + square(a);}
    //a-b之间的阶乘和
    public static int sumFact(int a,int b) {return a > b ? 0 : sumFact(a + 1, b) + fact(a);}
    //a-b之间的立方和
    public static int sumcube(int a, int b) {return a > b ? 0 : sumcube(a + 1, b) + cube(a);}

    private static List<Integer> clearFushu(List<Integer> list) {
        List<Integer> result = new ArrayList<Integer>();
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            result.add(list.get(i));
            if (list.get(i) < 0) {
                if (flag) {
                    result.remove(list.get(i));
                }
                flag = true;
            }

        }


        return result;
    }

    public static ArrayList<Integer> createArrayList(int... elements) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int element : elements) {
            list.add(element);
        }
        return list;
    }
}
