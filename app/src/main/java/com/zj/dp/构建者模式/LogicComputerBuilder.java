package com.zj.dp.构建者模式;

public class LogicComputerBuilder implements Builder{

    Computer mComputer = new Computer();

    @Override
    public void installCpu(String cpu) {
        mComputer.setCpu(cpu);
    }

    @Override
    public void installMainCard(String mainCard) {
        mComputer.setMainBorad(mainCard);
    }

    @Override
    public void installVideoCard(String videoCard) {
        mComputer.setVideoCard(videoCard);
    }

    @Override
    public Computer create() {
        return mComputer;
    }

}
