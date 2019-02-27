package com.zj.数据结构.树.bst;


public class BstTest {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
//        successorTest(bst);
        removeTest(bst);


        //非递归实现
//        BinarySearchTreeV2 bst2 = new BinarySearchTreeV2();
//        bst2.add(5);
//        bst2.add(1);
//        bst2.add(3);
//        bst2.add(6);
//        bst2.add(6);
//        bst2.add(7);
//        bst2.add(11);
//        bst2.add(1);
//
//        bst2.traverse();

    }

    private static void removeTest(BinarySearchTree bst) {

        bst.add(50);
        bst.add(29);
        bst.add(8);
        bst.add(2);
        bst.add(5);
        bst.add(4);
        bst.add(3);
        bst.add(44);
        bst.add(82);
        bst.add(10);
        bst.traverse();
        bst.remove(29);
        bst.traverse();
    }

    private static void successorTest(BinarySearchTree bst) {
        bst.add(50);
        bst.add(29);
        bst.add(8);
        bst.add(2);
        bst.add(5);
        bst.add(4);
        bst.add(3);
        bst.add(44);
        bst.add(77);
        bst.add(82);
        bst.add(10);
        bst.add(1);
        bst.add(11);
        bst.add(12);
        bst.add(13);

        bst.traverse();
        BinarySearchTree<Integer>.Node qNode = new BinarySearchTree<Integer>().new Node(new Integer(13));
        BinarySearchTree.Node successorNode = bst.getSuccessorNode(bst.getOnEle(qNode));
        System.out.println(qNode.value + " 的后继节点是：  "+successorNode.value);
        bst.traverse();
    }

}
