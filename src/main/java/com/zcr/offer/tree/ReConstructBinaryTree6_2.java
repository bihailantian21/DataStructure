package com.zcr.offer.tree;


/**
 * 6、重建二叉树
 * 附上一个利用中序数组和后序数组建立二叉树的程序，原理类似(在in数组找到post[poR]即可):
 */
public class ReConstructBinaryTree6_2 {

    /**
     * 后序：左右根
     * 中序：左根右
     * 1、根据前序和中序建树时，前序遍历的第一个结点就是根，在中序遍历中找到根所在的位置，
     * 计算的左子树长度(左边孩子的个数lLen)(可以得出右子树的长度 = 总长度-左子树长度-1)；
     * 2、这样在中序遍历中就确定了根节点的位置，且在pre数组中pre[pL+1, pL+lLen]之间都是根节点的左孩子；
     * 在in数组中in[iL, iL + lLen - 1]位置也都是根节点的左孩子，利用这个重新递归构造根节点的左子树即可；
     * 3、同理，在pre数组中pre[pL + lLen + 1 , pR]都是当前根节点的右孩子，
     * 在in数组中in[iL + lLen + 1 , iR]也都是当前根节点的右孩子，利用这两段重新构造根节点的右子树即可；
     * 4、注意根据前序遍历和中序遍历，中序遍历和后续遍历都可以建立一颗二叉树，
     * 但是根据前序遍历和后续遍历不可以确定一颗二叉树，前序和后序在本质上都只是将子节点和父节点分离，没有指明左右子树的能力。
     *
     * 递归的变量：
     * 递归结束条件：
     *
     * 例：
     *            0 1 2 3 4 5 6 7
     * 后序遍历序列{1,2,4,7,3,5,6,8}
     *                          _
     * 中序遍历序列{4,7,2,1,5,3,8,6}
     *                      llen
     *                        _
     * @param post
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTreeByInPost(int[] in, int[] post) {
        return rec(in, 0, in.length - 1, post, 0, post.length - 1);
    }

    public TreeNode rec(int[] in, int iL, int iR, int[] post, int poL, int poR) {
        if (iL > iR || poL > poR) return null;
        TreeNode root = new TreeNode(post[poR]);//最后一个是根
        int lLen = 0; // 左子树长度, 在in[]中找到 post[posR]的位置
        for (int i = iL; i <= iR && in[i] != post[poR]; i++, lLen++) ;
        root.left = rec(in, iL, iL + lLen - 1, post, poL, poL + lLen - 1);
        root.right = rec(in, iL + lLen + 1, iR, post, poL + lLen, poR - 1);
        return root;
    }
}
