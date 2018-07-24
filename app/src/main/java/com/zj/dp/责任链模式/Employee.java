package com.zj.dp.责任链模式;

/**
 * 员工类
 */
public class Employee {

    String name;

    public void requestMoney(int requestMoney, Leader leader) {
        System.out.println(name + "_向_" + leader.getName() + "_提出了申请_" + requestMoney);
        leader.handleMoney(requestMoney);
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", " +
                '}';
    }

}
