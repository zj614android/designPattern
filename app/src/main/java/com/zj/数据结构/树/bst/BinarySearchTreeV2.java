package com.zj.数据结构.树.bst;

import java.util.Stack;

/**
 * 二分搜索树 非递归遍历版本
 */

public class BinarySearchTreeV2<T extends Comparable> {

    Node root;
    int size;

    class Node {

        Node left;
        Node right;
        T value = null;

        public Node(T value) {
            this.value = value;
        }


        @Override
        public String toString() {

            return
                    "value == " + value.toString() +
                            "：：：left value == " + ((null != left && null != left.value) ? left.value.toString() : " null ") +
                            "__right value == " + ((null != right && null != right.value) ? right.value.toString() : " null ");
        }
    }

    public void add(T value) {
        root = nodeAdd(root, value);
    }

    /**
     * @param currRoot 当前根节点
     * @param newValue 新插入元素
     */
    private Node nodeAdd(Node currRoot, T newValue) {

        if(currRoot == null){
            size++;
            return new Node(newValue);
        }

        if (currRoot.value.compareTo(newValue) > 0) {//左插
               currRoot.left = nodeAdd(currRoot.left, newValue);//递归
        } else if (currRoot.value.compareTo(newValue) < 0) {//右插
            currRoot.right = nodeAdd(currRoot.right, newValue);//递归
        }

        return currRoot;

    }


    /**
     * 查询元素
     */
    public void contains() {

    }

    /**
     * 删除元素
     */
    public void delete() {

    }

    /**
     * 遍历，暴露给用户
     */
    public void traverse() {
        traversePre(root);
    }

    /**
     * 先序遍历，非递归实现
     */
    private void traversePre(Node rootnode) {

        Stack<Node> stack = new Stack<>();
        stack.push(rootnode);

        while(!stack.isEmpty()){
            Node currNode = stack.pop();

            if(currNode == null)
                return;
            else
                System.out.println(currNode);//访问元素

            if(null != currNode.right)
            stack.push(currNode.right);

            if(null != currNode.left)
            stack.push(currNode.left);
        }

    }


    /**
     * TODO 中序遍历非递归
     */
    private void traverseMid(Node node) {


    }


    /**
     * TODO 后序遍历非递归
     */
    private void traverseAfter(Node node) {

    }

}
