package com.itheima.demo5.Consumer;

import java.util.function.Consumer;

/**
 * @author shangli
 * @description: TODO Consumer接口的默认方法andThen
 * 作用：需要两个Consumer接口，可以把两个Consumer接口组合到一起，再对数据进行消费
 *
 * 例如：
 * Consumer<String> con1
 * Consumer<String> con2
 * String s = "hello";
 * con1.accept(s);
 * con2.accept(s);
 * 连接两个Consumer接口，再进行消费
 * con1.andThen(con2).accept(s);
 * @date create in 2020/5/13 17:34
 */
public class Demo02AndThen {
    //定义一个方法，方法的参数传递一个字符串和两个Consumer接口，Consumer接口的泛型使用字符串
    public static void method(String s, Consumer<String> con1, Consumer<String> con2){
        //con1.accept(s);
        //con2.accept(s);
        //使用andThen方法，把两个Consumer接口连接到一起，再消费数据
        //con1连接con2，先执行con1消费数据，再执行con2消费数据
        con1.andThen(con2).accept(s);
    }

    public static void main(String[] args) {
        //消费方式：con1-把字符串转换为大写输出，con2-把字符串转换为小写输出
        method("Hello",(s)-> System.out.println(s.toUpperCase()),(s)-> System.out.println(s.toLowerCase()));
    }
}
