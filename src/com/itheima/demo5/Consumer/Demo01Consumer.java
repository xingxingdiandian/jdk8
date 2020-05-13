package com.itheima.demo5.Consumer;

import java.util.function.Consumer;

/**
 * @author shangli
 * @description: TODO java.util.function.Consumer消费型接口
 * 它消费一个数据，其数据类型由泛型决定
 * Consumer接口中包含抽象方法void accept(T t)，意为消费一个指定泛型的数据
 * Consumer接口是一个消费型接口，泛型执行什么类型，就可以使用accept方法消费什么类型的数据
 * 至于具体怎么消费，需要自定义（输出，计算...）
 * @date create in 2020/5/13 17:18
 */
public class Demo01Consumer {
    /*
        定义一个方法
        方法参数传递一个字符串的名字
        方法的参数传递Consumer接口，泛型使用Strinf
        可以使用Consumer接口消费字符串的姓名
     */
    public static void method(String name, Consumer<String> consumer){
        consumer.accept(name);
    }

    public static void main(String[] args) {
        //调用method方法，传递字符串姓名，方法的另一个参数是Consumer接口，是一个函数式接口，所以可以传递Lambda表达式
        method("张三", (name)-> {
            //对字符串进行消费
            //消费方式：直接输出
            //System.out.println(name);

            //消费方式：把字符串进行反转输出
            String reName = new StringBuffer(name).reverse().toString();
            System.out.println(reName);
        });
    }
}
