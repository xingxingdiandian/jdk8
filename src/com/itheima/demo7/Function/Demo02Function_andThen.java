package com.itheima.demo7.Function;

import java.util.function.Function;

/**
 * @author shangli
 * @description:
 * TODO Function接口中的默认方法andThen：用来进行组合操作
 *      需求：
 *          把String类型的“123”，转换为Integer类型，把转换后的结果加10
 *          把增加后的Integer类型的数据，转换为String类型
 *      分析：
 *          转换了两次
 *          第一次是把String类型转换为了Integer类型
 *          第二次把Integer类型转换为了String类型
 *          我们可以使用andThen方法，把两次转换组合在一起使用
 * @date create in 2020/5/14 19:08
 */
public class Demo02Function_andThen {
    public static void change(String s, Function<String, Integer> fun1, Function<Integer, String> fun2){
        String out = fun1.andThen(fun2).apply(s);
        System.out.println(out);
    }

    public static void main(String[] args) {
        String s = "123";
        //先加十，再转换
        change(s, s1 -> Integer.parseInt(s1)+10, i->i+"");
        //这是转换，再加十
        // change(s, Integer::parseInt, int1->String.valueOf(int1+10));
    }

}
