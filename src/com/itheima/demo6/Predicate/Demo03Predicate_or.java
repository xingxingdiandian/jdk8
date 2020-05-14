package com.itheima.demo6.Predicate;

import java.util.function.Predicate;

/**
 * @author shangli
 * @description: TODO Predicate or方法
 * 需求：判断一个字符串，有两个判断条件
 *      1.判断字符串的长度是否大于5
 *      2.判断字符串中是否包含a
 *  满足一个条件即可，我们就可以使用||运算符连接两个条件
 *
 *  Predicate接口中有一个方法or，标识或者关系，也可以用于连接两个判断条件
 *  default Predicate<T> or(Predicate<? super T> other) {
 *         Objects.requireNonNull(other);
 *         return (t) -> this.test(t) || other.test(t);
 *  }
 *  方法内部的两个判断条件，也是使用||运算符连接起来的
 * @date create in 2020/5/13 19:02
 */
public class Demo03Predicate_or {
    /**
     定义一个方法，方法的参数传递一个字符串
     传递两个Predicate接口
        一个用于判断字符串的长度是否大于5
        一个用于判断字符串中是否包含a
        满足一个条件即可
     */
    public static boolean checkString(String s, Predicate<String> pre1, Predicate<String> pre2){
        //return pre1.test(s) || pre2.test(s);
        return pre1.or(pre2).test(s);
    }

    public static void main(String[] args) {
        //定义一个字符串
        String s = "abcde";
        boolean b = checkString(s,(String str)->{
            //判断字符串的长度是否大于5
            return str.length()>5;
        },(String str)->{
            //判断字符串中是否包含a
            return str.contains("a");
        });
        System.out.println(b);
    }
}
