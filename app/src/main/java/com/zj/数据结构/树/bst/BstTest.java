package com.zj.数据结构.树.bst;

import com.zj.数据结构.树.avl.BinarySearchTree;

public class BstTest {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(1);
        bst.add(3);
        bst.add(6);
        bst.add(6);
        bst.add(7);
        bst.add(11);
        bst.add(1);

        bst.traverse();
        BinarySearchTreeV2 bst2 = new BinarySearchTreeV2();
        bst2.add(5);
        bst2.add(1);
        bst2.add(3);
        bst2.add(6);
        bst2.add(6);
        bst2.add(7);
        bst2.add(11);
        bst2.add(1);

        bst2.traverse();



    }

}
