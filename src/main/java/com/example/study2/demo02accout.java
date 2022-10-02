package com.example.study2;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-10-02  21:42
 * @Description: 不安全的线案例2
 * @Version: 1.0
 */
public class demo02accout {
    public static void main(String[] args) {
        account zssd = new account(100, "zssd");
        blank you = new blank(zssd, 50, "你");
        blank me = new blank(zssd, 100, "我");
        you.start();
        me.start();
    }
}
class account{
    int money;
    String name;

    public account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
class blank extends Thread{
    account account;//账户
    int getMoney;//取了多少钱
    int nowMoney;//余额
    public blank(account account,int getMoney,String name){
        super(name);
        this.account=account;
        this.getMoney=getMoney;

    }
    //取钱

    @Override
    public void run() {
        if (account.money-getMoney<0){
            System.out.println(Thread.currentThread().getName()+"钱不够");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money=account.money-getMoney;//账户的钱
        nowMoney=nowMoney+getMoney;//手里的钱
        System.out.println(account.name+"余额位"+account.money);
//        Thread.currentThread().getName()=this.getName();
        System.out.println(this.getName()+"手里的钱"+nowMoney);
    }
}
