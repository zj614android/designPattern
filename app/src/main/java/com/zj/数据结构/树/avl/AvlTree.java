package com.zj.数据结构.树.avl;


public class AvlTree<T extends Comparable>  {

    AvlTree.Node root;
    int size;

    class Node {

        AvlTree.Node left;
        AvlTree.Node right;
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

        if (root == null) {
            root = new AvlTree.Node(value);
            size++;
            return;
        } else {
            nodeAdd(root, value);
        }

    }

    /**
     * @param currNode 当前根节点
     * @param newValue 新插入元素
     */
    /**
     * 二分搜索树每个节点的值：
     * a.大于其左子树所有节点的值；
     * b.小于其右子树所有节点的值；
     */
    private void nodeAdd(AvlTree.Node currRoot, T newValue) {

        //无重复元素
        if (currRoot.value.compareTo(newValue) == 0) {
            return;
        }

        //compareTo 前一个元素和后一个元素比较--返回整数，1，0,-1；返回1表示大于，返回-1表示小于，返回0表示相等；
        if (currRoot.value.compareTo(newValue) > 0) {//左插

            //当前根节点大于插入值，且当前根节点的左子树为空，所以该值应该插入左子树
            if (currRoot.left == null) {
                currRoot.left = new AvlTree.Node(newValue);
                size++;
                return;
            } else {
                //当前根节点大于插入值，且当前根节点的左子树不为空，则递归
                nodeAdd(currRoot.left, newValue);//递归
            }
        } else if (currRoot.value.compareTo(newValue) < 0) {//右插

            //右插同理左插
            if (currRoot.right == null) {
                currRoot.right = new AvlTree.Node(newValue);
                size++;
                return;
            } else {
                nodeAdd(currRoot.right, newValue);//递归
            }

        }

    }


    /**
     * 暴露给用户
     */
    public void traverse() {
        traversePre(root);
    }

    /**
     * 先序遍历
     */
    private void traversePre(AvlTree.Node node) {


        if (node == null)
            return;

        System.out.println(node.toString());//访问元素
        traversePre(node.left);
        traversePre(node.right);
    }


    /**
     * 中序遍历
     */
    private void traverseMid(AvlTree.Node node) {

        if (node == null)
            return;

        traversePre(node.left);
        System.out.println(node.toString());//访问元素
        traversePre(node.right);
    }


    /**
     * 后序遍历
     */
    private void traverseAfter(AvlTree.Node node) {

        if (node == null)
            return;

        traversePre(node.left);
        traversePre(node.right);
        System.out.println(node.toString());//访问元素
    }
    
    
}
