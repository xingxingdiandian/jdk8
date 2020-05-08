package com.demo3.LambdaTest;

/**
 * @author shangli
 * @description:
 * TODO 例如java.lang.Runnable接口就是一个函数式接口
 * TODO 假设有一个startThread方法使用该接口作为参数，那么就可以使用lambda进行传参
 * TODO 这种情况其实和Thread类的构造方法参数为Runnable没有本质区别
 * @date create in 2020/5/8 17:27
 */
public class Demo01Runnable {
    //定义一个方法startThread，方法的参数使用函数式接口Runnable
    public static void startThread(Runnable run){
        //开启多线程
        new Thread(run).start();
    }

    public static void main(String[] args) {
        //1.调用startThread方法，方法的参数是一个接口，可以传递这个接口的匿名内部类
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"-->线程启动了");
            }
        });
        //2.调用startThread方法，方法的参数是一个函数式接口，可以传递lambda表达式
        startThread(()->{
            System.out.println(Thread.currentThread().getName()+"-->线程启动了");
        });
        //3.调用startThread方法，方法的参数是一个函数式接口，优化lambda表达式
        startThread(()->System.out.println(Thread.currentThread().getName()+"-->线程启动了"));
    }

}
