package com.example.study;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-09-29  10:08
 * @Description: lamdba表达式
 *  函数式接口的定义：
 *      任何接口,如果只包含唯一一个抽象方法，那么它就是一个函数氏接口
 *      对于函数式接口，我们可以通过lamdba表达式来创建该接口的对象
 * @Version: 1.0
 */
public class demo09lambda {
    //静态内部类
    static class like2 implements ILike{
        @Override
        public void lamdba() {
            System.out.println("22静态代理lambda");
        }
    }
    public static void main(String[] args) {
        ILike like = new like();
        like.lamdba();
        like = new like2();
        like.lamdba();

        //局部内部类
        class like3 implements ILike{
            @Override
            public void lamdba() {
                System.out.println("333局部内部类");
            }
        }
        like=new like3();
        like.lamdba();

        //匿名内部类 必须借助接口或者父类
        like=new ILike() {
            @Override
            public void lamdba() {
                System.out.println("444匿名内部类");
            }
        };
        like.lamdba();

        //lambda表达式
        like=()->{
            System.out.println("555lambda表达式");
        }
         ;
        like.lamdba();

    }
}
interface ILike{
    void lamdba();
}
class  like implements ILike{
    @Override
    public void lamdba() {
        System.out.println("111实现类lamdba");
    }
}
