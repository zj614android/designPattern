package com.zj.dp.构建者模式;

public interface Builder {
    void installCpu(String cpu);
    void installMainCard(String mainCard);
    void installVideoCard(String showCard);
    Computer create();
}
