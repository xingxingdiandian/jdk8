package com.demo3.LambdaTest;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author shangli
 * @description:
 * TODO 如果一个方法的返回值类型是一个函数式接口，那么可以直接返回一个lambda表达式
 * TODO 当需要通过一个方法来获取一个java.util.Comparator接口类型的对象作为排序器时，就可以调用该方法获取
 * @date create in 2020/5/8 17:40
 */
public class Demo02Comparator {
    //定义一个方法，方法的返回值类型使用函数式接口Comparator
    public static Comparator<String> getComparator(){
        //1.方法的返回类型是一个接口，那么我们可以返回这个接口的匿名内部类
        /*return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //按照字符串长度的降序排序
                return o2.length()-o1.length();
            }
        };
        */

        //2.方法的返回类型是一个函数式接口，可以返回一个lambda表达式
        /*return (String o1, String o2)->{
            //按照字符串长度的降序排序
            return o2.length()-o1.length();
        };*/

        //3.方法的返回类型是一个函数式接口，优化lambda表达式
        return (o1, o2)->o2.length()-o1.length();
    }

    public static void main(String[] args) {
        String[] arr = {"aaa","b","cccccccc","dddddddddddddddd"};
        //调用Array中的sort方法，对字符串数组进行排序
        Arrays.sort(arr,getComparator());
        System.out.println(Arrays.toString(arr));
    }
}
