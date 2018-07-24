package com.zj.dp.构建者模式;

/**
 * 商家的指挥者类用来规范组装电脑的流程规范
 * <p>
 * 先安装主板
 * 再安装CPU
 * 最后安装内存并组装成电脑：
 */
public class Director {

    Builder mBuilder = null;

    public Director(Builder mBuilder) {
        this.mBuilder = mBuilder;
    }

    public Computer CreateComputer(String cpu, String mainBoard, String videoCard) {
        this.mBuilder.installCpu(cpu);
        this.mBuilder.installMainCard(mainBoard);
        this.mBuilder.installVideoCard(videoCard);
        return mBuilder.create();
    }
}
