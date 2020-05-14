package com.itheima.demo7.Function;

import java.util.function.Function;

/**
 * @author shangli
 * @description:
 * TODO 练习：自定义函数模型拼接
 *      题目
 *          请使用Function进行函数模型的拼接，按照顺序需要执行的多个函数操作为：
 *          String str = "赵丽颖，20";
 *      分析：
 *          1.将字符串截取数字年龄部分，得到字符串；
 *          2.将上一步的字符串转换成为int类型的数字；
 *          3.将上一步的int数字加100，得到结果int数字。
 * @date create in 2020/5/14 19:33
 */
public class Demo03Test {
    /**
     * 定义一个方法
     * 参数传递包含姓名和年龄的字符串
     * 参数再传递3个Function接口用于类型转换
     */
    public static int change(String s, Function<String,String> fun1,
                             Function<String,Integer> fun2, Function<Integer,Integer> fun3){
        return fun1.andThen(fun2).andThen(fun3).apply(s);
    }

    public static void main(String[] args) {
        String str = "赵丽颖，20";
        int out = change(str, s1->s1.split("，")[1], Integer::parseInt, i->i+100);
        System.out.println(out);
    }
}
