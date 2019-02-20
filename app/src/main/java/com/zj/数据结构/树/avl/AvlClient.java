package com.zj.数据结构.树.avl;


public class AvlClient {

    public static void main(String[] args) {

        AvlTree avl = new AvlTree();
        avl.add(5);
        avl.add(1);
        avl.add(3);
        avl.add(6);
        avl.add(6);
        avl.add(7);
        avl.add(11);
        avl.add(1);
        avl.add(18);
        avl.add(4);

        avl.traverse();

    }

}
