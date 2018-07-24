package com.zj.dp.构建者模式;

public class TestBuildler {

    public static void main(String[] args) {
        LogicComputerBuilder logicComputerBuilder = new LogicComputerBuilder();
        Director director = new Director(logicComputerBuilder);
        Computer computer = director.CreateComputer("intel-i7-8700k", "技嘉-Z370", "NVIDIA-1080-Ti");
        System.out.println(computer.toString());
    }

}
