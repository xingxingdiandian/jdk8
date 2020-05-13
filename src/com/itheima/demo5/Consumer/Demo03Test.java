package com.itheima.demo5.Consumer;

import java.util.function.Consumer;

/**
 * @author shangli
 * @description: TODO 格式化打印信息
 * 将String[] array = {"迪丽热巴，女","古力娜扎，女","马尔扎哈，男"};按照格式“姓名：XX。性别：XX。”打印出来
 * @date create in 2020/5/13 17:49
 */
public class Demo03Test {
    //自己写的
    /*public static void main(String[] args) {
        String[] array = {"迪丽热巴，女","古力娜扎，女","马尔扎哈，男"};
        for (String s : array) {
            mothed(s, (s1)->{
                String sout = "姓名："+s1.split("，")[0]+"。性别："+s1.split("，")[1]+"。";
                System.out.println(sout);
            });
        }
    }
    public static void mothed(String s, Consumer<String> con) {
        con.accept(s);
    }*/

    //视频代码：注意，将姓名和性别分开消费，区分两者进行消费
    public static void printInfo(String[] array, Consumer<String> con1, Consumer<String> con2){
        for (String s : array) {
            //使用andThen方法连接两个Consumer接口，消费字符串
            con1.andThen(con2).accept(s);
        }
    }

    public static void main(String[] args) {
        String[] array = {"迪丽热巴，女","古力娜扎，女","马尔扎哈，男"};
        printInfo(array,
                //消费方式：对message进行切割，获取姓名，按照指定格式输出
                (message)->System.out.print("姓名：" + message.split("，")[0]),
                //消费方式：对message进行切割，获取性别，按照指定格式输出
                (message)->System.out.println("。性别：" + message.split("，")[1]+"。"));
    }
}
