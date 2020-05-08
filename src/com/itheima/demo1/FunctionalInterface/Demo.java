package com.itheima.demo1.FunctionalInterface;

/**
 * @author shangli
 * @description:
 * TODO 函数式接口的使用：
 * 一般可以作为方法的参数和返回值类型
 *
 * @date create in 2020/5/6 11:32
 */
public class Demo {
    //定义一个方法，参数使用函数式接口MyFunctionalInterface
    public static void show(MyFunctionalInterface myInter) {
        myInter.method();
    }

    public static void main(String[] args) {
        //1.参数使用实现类
        show(new MyFunctionalInterfaceImpl());

        //2.参数使用匿名内部类//匿名内部类会生成class文件
        show(new MyFunctionalInterface() {
            @Override
            public void method() {
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }
        });

        //3.上一方法的匿名内部类使用lambda表达式//使用lambda和匿名内部类底层原理不同
        show(()->{
            System.out.println("使用lambda表达式重写接口中的抽象方法");
        });

        //4.对上一方法进行简化
        show(()->System.out.println("使用lambda表达式重写接口中的抽象方法"));
    }
}
