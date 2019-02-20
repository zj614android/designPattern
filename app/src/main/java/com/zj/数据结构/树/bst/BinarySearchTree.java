package com.zj.数据结构.树.avl;


public class BinarySearchTree<T extends Comparable> {


    final int DIR_LEFT = 0;
    final int DIR_RIGHT = 1;
    BinarySearchTree.Node root;
    int size;

    class Node {
        int height = 0;
        BinarySearchTree.Node left;
        BinarySearchTree.Node right;
        BinarySearchTree.Node parent;
        T value = null;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value + "__" +
                    "height=" + height +
                    ", left=" + (left != null ? left.value : "null") +
                    ", right=" + (right != null ? right.value : "null") +
                    ", parent=" + (parent != null ? parent.value : "null") +
                    '}';
        }
    }

    /**
     * 添加元素
     *
     * @param value
     */
    public void add(T value) {

        if (root == null) {
            root = new BinarySearchTree.Node(value);
            size++;
            return;
        } else {
            nodeAdd(root, value);
        }

    }


    public void delete(T value){


    }

    /**
     * @param currRoot 当前根节点  即需要将来新元素挂到哪一个根节点
     * @param newValue 新插入元素
     *                 <p>
     *                 二分搜索树每个节点的值：
     *                 a.大于其左子树所有节点的值；
     *                 b.小于其右子树所有节点的值；
     */
    private void nodeAdd(BinarySearchTree.Node currRoot, T newValue) {
        boolean willUpdateFlag = false;
        //无重复元素
        if (currRoot.value.compareTo(newValue) == 0) {
            return;
        }

        //compareTo 前一个元素和后一个元素比较--返回整数，1，0,-1；返回1表示大于，返回-1表示小于，返回0表示相等；
        if (currRoot.value.compareTo(newValue) > 0) {//左插

            //当前根节点大于插入值，且当前根节点的左子树为空，所以该值应该插入左子树
            if (currRoot.left == null) {
                currRoot.left = new BinarySearchTree.Node(newValue);

                currRoot.left.parent = currRoot;
                size++;

                //如果需要更新高度（willUpdateHeight方法内逻辑） 则去更新  updateHeight

                willUpdateFlag = willUpdateHeight(currRoot.left, DIR_LEFT);

                if (willUpdateFlag){
                    System.out.println("收敛触发："+newValue);
                    updateHeight(currRoot.left);
                }
            } else {
                //当前根节点大于插入值，且当前根节点的左子树不为空，则递归
                nodeAdd(currRoot.left, newValue);//递归
            }
        } else if (currRoot.value.compareTo(newValue) < 0) {//右插

            //右插同理左插
            if (currRoot.right == null) {
                currRoot.right = new BinarySearchTree.Node(newValue);

                currRoot.right.parent = currRoot;
                size++;
                //如果需要更新高度（willUpdateHeight方法内逻辑） 则去更新  updateHeight
                willUpdateFlag = willUpdateHeight(currRoot.right, DIR_RIGHT);
                if (willUpdateFlag){
                    System.out.println("收敛触发："+newValue);
                    updateHeight(currRoot.right);
                }
            } else {
                nodeAdd(currRoot.right, newValue);//递归
            }
        }

    }

    /**
     * 判断是否需要进行高度更新
     *
     * @param node 插入的节点
     * @return
     */
    private boolean willUpdateHeight(Node node, int DIRECT) {

        // 当新插入一个节点
        // 如果该节点的父节点的兄弟节点为空或者不为空且高度为0时，这个时候说明高度需要整个树需要更新高度
        // 如果该节点的父亲节点是根节点，则只需要考虑该节点自身的兄弟节点


        if(null == node){
            return false;
        }

        boolean godRootNodeFlag = isGodRootNode(node.parent);

        switch (DIRECT) {
            case DIR_LEFT:
                if (godRootNodeFlag){
                    if(node.parent.right == null || node.parent.right.height == 0){
                        return true;
                    }
                }else {
                    if(node.parent != null &&
                            node.parent.parent != null &&
                            node.parent.parent.right == null ||
                            node.parent.parent.right.height == 0 ||
                            node.parent.parent.right.height == node.parent.height){
                        return true;
                    }
                }
                break;
            case DIR_RIGHT:
                if (godRootNodeFlag){
                    if(node.parent.left == null || node.parent.left.height == 0){
                        return true;
                    }
                }else {
                    if(node.parent != null &&
                            node.parent.parent != null &&
                            node.parent.parent.left == null ||
                            node.parent.parent.left.height == 0 ||
                            node.parent.parent.left.height == node.parent.height){
                        return true;
                    }
                }
                break;
        }

        return false;
    }


    /**
     * 更新收敛高度
     *
     * @param newNode 插入的节点
     */
    private void updateHeight(Node newNode) {
        newNode.height += 1;

        if (!isGodRootNode(newNode)) {//如果不是树根就+1并递归通知再上一级的父元素
            updateHeight(newNode.parent);
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
    private void traversePre(BinarySearchTree.Node node) {

        if (node == null)
            return;

        System.out.println(node.toString());//访问元素
        traversePre(node.left);
        traversePre(node.right);
    }


    /**
     * 中序遍历
     */
    private void traverseMid(BinarySearchTree.Node node) {

        if (node == null)
            return;

        traversePre(node.left);
        System.out.println(node.toString());//访问元素
        traversePre(node.right);
    }


    /**
     * 后序遍历
     */
    private void traverseAfter(BinarySearchTree.Node node) {

        if (node == null)
            return;

        traversePre(node.left);
        traversePre(node.right);
        System.out.println(node.toString());//访问元素
    }


    /**
     * 如果没有父节点表示已经是树根了
     *
     * @param node
     * @return
     */
    private boolean isGodRootNode(BinarySearchTree.Node node) {
        if (null != node && node.parent == null) {
            return true;
        }
        return false;
    }




}
