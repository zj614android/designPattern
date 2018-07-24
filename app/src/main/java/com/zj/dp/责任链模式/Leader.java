package com.zj.dp.责任链模式;

public abstract class Leader {

    private String name;//领导名字
    private Leader nextLeader;//链的体现，下家领导
    private int handelArea;//审批额度区间

    public Leader(int handelArea, String name) {
        this.handelArea = handelArea;
        this.name = name;
    }

    void handleMoney(int money) {
        if (money > handelArea) {
            if (null != nextLeader) {
                nextLeader.handleMoney(money);
                return;
            } else {
                if (getName() != null && getName().equals("boss")) {
                    System.out.println("已经超过大Boss的审批额度");
                } else {
                    System.out.println(getName() + "的下家领导为空");
                }
            }
        } else {
            System.out.println("小子，你申请的钱" + money + "由我" + name + "批下来了");
        }
    }

    void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
