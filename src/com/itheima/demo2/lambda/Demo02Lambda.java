package com.itheima.demo2.lambda;

/**
 * @author shangli
 * @description:
 * 日志问题：当等级为1时，拼接字符串输出；当等级为2时，不输出，字符串拼接浪费内存
 * TODO Lambda进行日志优化
 * Lambda的特点：延迟加载
 * Lambda的使用前提：必须存在函数式接口
 * @date create in 2020/5/7 17:33
 */
public class Demo02Lambda {
    public static void showLog(int level, MessageBuilder mb){
        if(level == 1){
            System.out.println(mb.builderMessage());
        }
    }

    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "World";
        String s3 = "Java";

        showLog(1, ()->{
            System.out.println("不满足状态不执行");
            return s1+s2+s3;
        });

        /*
        使用lambda表达式作为参数传递，仅仅是把参数传递到showLog方法中
        只有满足条件，日志等级是1级
            才会调用接口MessageBuilder中的方法builderMessage
            才会进行字符串的拼接
        只有条件不满足，日志的等级不是1级
            那么MessageBuilder接口中的方法builderMessage也不会执行
            所以拼接字符串的代码也不会执行
        所以不会存在性能的浪费
         */
        showLog(2, ()->{
            System.out.println("不满足状态不执行");
            return s1+s2+s3;
        });
    }
}
