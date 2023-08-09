package com.ak.Trees.BinaryTreeAndBST;

public class ChildrenSumProperty {
    //🥥if both children sum is less than parent, make children's value to parent's value.
    //🥥 if both children values sum is greater than or equal to parent, make parent's value to children's sum.
    //🥥 recursively go left and right. Traversal type: DFS.
    //🥥 when coming back up the tree, take children sum and replace it in parent.
    //🥥 at any point we reach null, just return (base case)
    //🥥 Intuition: while going down, increase the children values, so we make sure to never fall short, then all we have to do is sum both children and replace it in parent.

    public static void changeTree(Node root){
        if (root == null) return;
        int child = 0;
        if (root . left!=null) {
            child += root . left . data;
        }
        if (root . right!=null) {
            child += root . right . data;
        }

        if (child < root . data) {
            if (root . left!=null) root . left . data = root . data;
            else if (root . right!=null) root . right . data = root . data;
        }

        changeTree(root . left);
        changeTree(root . right);

        int tot = 0;
        if (root . left!=null) tot += root . left . data;
        if (root . right!=null) tot += root . right . data;
        if (root . left!=null || root . right!=null) root . data = tot;
    }
}
