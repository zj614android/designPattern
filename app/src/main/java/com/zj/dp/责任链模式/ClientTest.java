package com.zj.dp.责任链模式;

public class ClientTest {

    public static void main(String[] args) {

        //员工初始化
        Employee xiaoMing = new Employee("小明");

        //领导初始化
        BossLeader bossLeader = new BossLeader(50000, "boss");
        MoneyLeader moneyLeader = new MoneyLeader(10000, "moneyLeader");
        GroupLeader groupLeader = new GroupLeader(1000, "groupLeader");
        groupLeader.setNextLeader(moneyLeader);
        moneyLeader.setNextLeader(bossLeader);

        //发起员工请求
        xiaoMing.requestMoney(15000, groupLeader);
        xiaoMing.requestMoney(1500, moneyLeader);
        xiaoMing.requestMoney(150, groupLeader);
    }
}
