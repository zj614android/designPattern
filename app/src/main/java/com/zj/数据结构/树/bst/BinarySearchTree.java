package com.zj.数据结构.树.bst;


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


    public void setRoot(Node root) {
        this.root = root;
    }


    public void remove(T delValue){
        delete(root,new BinarySearchTree.Node(delValue));
    }

    /**
     * 元素删除
     * @param delNode
     */
    private boolean delete(BinarySearchTree.Node srcNode,BinarySearchTree.Node delNode) {
        if (srcNode == null )
            return false;

        delete(srcNode.left, delNode);

        if (srcNode.value.compareTo(delNode.value) == 0) {//相等表示有这个节点
            return handleDeleteNode(srcNode);
        }

        delete(srcNode.right, delNode);

        return false;
    }

    /**
     * 处理节点删除
     *
     * @param srcNode 源节点，这个参数传进来的是
     * @return
     */
    private boolean handleDeleteNode(Node srcNode) {

        if (srcNode.left == null && srcNode.right == null) {//叶子节点

            if (srcNode.parent.left != null && srcNode.parent.left.value.compareTo(srcNode.value) == 0) {
                srcNode.parent.left = null;
                srcNode.parent = null;
                return true;
            } else if (srcNode.parent.right != null && srcNode.parent.right.value.compareTo(srcNode.value) == 0) {
                srcNode.parent.right = null;
                srcNode.parent = null;
                return true;
            }else {
                System.out.println("异常：叶子节点情况");
            }

        } else if ((srcNode.left != null && srcNode.right == null) || (srcNode.left == null && srcNode.right != null)) {//瘸子子树

            BinarySearchTree.Node tempValNode = null;
            if (srcNode.left != null && srcNode.right == null) {//右瘸时

                tempValNode = srcNode.left;

                //判断当前删除节点是父节点的左或者右
                if (srcNode.parent.left.value.compareTo(srcNode.value) == 0) {//如果当前待删除节点是其父节点的左节点时
                    srcNode.parent.left = tempValNode;
                } else if (srcNode.parent.right.value.compareTo(srcNode.value) == 0) {//如果当前待删除节点是其父节点的右节点时
                    srcNode.parent.right = tempValNode;
                } else {
                    System.out.println("异常：判断当前删除节点是父节点的左或者右");
                }

            } else if (srcNode.left == null && srcNode.right != null) {//左瘸时

                tempValNode = srcNode.right;

                if (srcNode.parent.left.value.compareTo(srcNode.value) == 0) {//如果当前待删除节点是其父节点的左节点时
                    srcNode.parent.left = tempValNode;
                } else if (srcNode.parent.right.value.compareTo(srcNode.value) == 0) {//如果当前待删除节点是其父节点的右节点时
                    srcNode.parent.right = tempValNode;
                } else {
                    System.out.println("异常：判断当前删除节点是父节点的左或者右");
                }

            } else {//异常
                System.out.println("异常：瘸子子树情况");
                return false;
            }

            if(null != tempValNode){
                tempValNode.parent = srcNode.parent;
            }else {
                System.out.println("异常：瘸子子树情况：改变爷孙关系为父子关系");
                return false;
            }

        } else if (srcNode.left != null && srcNode.right != null) {//左右子树都有
            //取出后继节点
            BinarySearchTree.Node successorNode = getSuccessorNode(srcNode);
            System.out.println(srcNode.value + "    后继节点：  " + successorNode.value);

            //1.值的替换
            srcNode.value = (T) successorNode.value;

            //2.置位空
            if (successorNode.parent.left.value.compareTo(successorNode.value) == 0){//左
                successorNode.parent.left = null;
            }else {//右
                successorNode.parent.right = null;
            }

            successorNode = null;
        } else {//异常
            System.out.println("异常：3种情况之外");
        }

        return true;
    }

    /**
     * 获取指定元素的后继节点
     * @return
     */
    public Node getSuccessorNode(BinarySearchTree.Node node) {

        if(node == null)
            return null;

        if(node.right == null){//如果该节点没有右子树,那么要分两种情况:
            //a>如果node结点没有右子树,判断当前结点node是不是它父亲的左孩子，如果是，那么它父亲就是它的后继；
            //比如：1，它首先没有右子树，然后当前节点1又是它父亲的左孩子，所以它的后继就是它的父亲2.

            if (null != node.parent.left && node.parent.left.value.compareTo(node.value) == 0) {//node是不是它父亲的左孩子
                //那么它父亲就是它的后继；
                return node.parent;
            } else if (null != node.parent.right && node.parent.right.value.compareTo(node.value) == 0) {//b>如果node结点没有右子树, 判断当前结点是不是它父亲的右孩子，
                return getParentFather(node);
            } else {
                System.out.println("异常：getSuccessorNode");
            }

        }else {//如果该节点有右子树
            //返回该右子树上的最小值（即左子树的最深元素）若没有左子树则返回该元素本身（因其右子树肯定比其本身要大））
            if(node.right.left == null)
                return node.right;

            return getLeftMost(node.right.left);
        }

        return null;
    }

    /**
     * 如果是，那么一路往父节点方向回溯，直到找到某一个父节点(ParentA)是其自己父节点(ParentA’s Fathter)的左子树，
     * 那么这个ParentA’s Fathter就是当前节点Node的后继节点
     * @param node
     * @return
     */
    private Node getParentFather(Node node) {
        if(null != node.parent.parent.left && node.parent.value.compareTo(node.parent.parent.left.value) == 0){
            return node.parent.parent;
        }

        return getParentFather(node.parent);
    }

    //返回该右子树上的最小值（即左子树的最深元素）
    private Node getLeftMost(Node node) {

        if(node.left == null){
            return node;
        }

        return getLeftMost(node.left);
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
        System.out.println("\n >>>>>>>>>>>>>> traverse <<<<<<<<<<<<<<<< \n");
//        traversePre(root);
        traverseMid(root);
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

        traverseMid(node.left);
        System.out.println(node.toString());//访问元素
        traverseMid(node.right);
    }


    /**
     * 后序遍历
     */
    private void traverseAfter(BinarySearchTree.Node node) {

        if (node == null)
            return;

        traverseAfter(node.left);
        traverseAfter(node.right);
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


    /**
     * 通过遍历获取一个元素
     */
    public Node getOnEle(Node targetNode){
        Node result = getTargetNode(root,targetNode);
        return result;
    }


    /**
     * 获取目标节点
     * @param srcNode
     * @param targetNode
     * @return
     */
    private Node getTargetNode(Node srcNode, Node targetNode) {

        Node curNode = srcNode;
        while (true){
            if(curNode.value.compareTo(targetNode.value) == 0)
                return curNode;
            if(curNode.value.compareTo(targetNode.value) < 0){
                curNode = curNode.right;
            }else {
                curNode = curNode.left;
            }
        }
    }


}
