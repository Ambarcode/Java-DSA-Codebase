package com.ak.Trees.BinaryTreeAndBST;

import java.util.ArrayList;
import java.util.List;


public class LowestCommonAncestor {

    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;


        TreeNode(int value){
            this.val=value;
            this.left=null;
            this.right=null;
        }

    }
    //Brute Force Approach: Use node to root path approach
    //After finding node to root path for both the nodes , we'll start the loop from the root , till the point they become unequal
    //lets start
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        //we'll use the approach of node to root path
        List<Integer> list1 = nodeToRootPath(p, p.val);
        List<Integer> list2 = nodeToRootPath(q, q.val);

        int i = list1.size() - 1;
        int j = list2.size() - 1;

        while (i >= 0 && j >= 0 && list1.get(i).equals(list2.get(j))) {
            i--;
            j--;
        }
        i++;

        if (i >= 0 && i < list1.size()) {
            return new TreeNode(list1.get(i));
        }

        return null;
    }
    private static List<Integer> nodeToRootPath(TreeNode node , int data){
        if (node == null) {
            return new ArrayList<>();
        }

        if (node.val == data) {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            return list;
        }

        List<Integer> leftList = nodeToRootPath(node.left, data);
        if (leftList.size() > 0) {
            leftList.add(node.val);
            return leftList;
        }

        List<Integer> rightList = nodeToRootPath(node.right, data);
        if (rightList.size() > 0) {
            rightList.add(node.val);
            return rightList;
        }

        return new ArrayList<>();

    }






    public Node lowestCommonAncestor2(Node root, Node p, Node q) {
       if (root==null || root==p || root==q) return root;

       //Traverse left and right
        Node left=lowestCommonAncestor2(root.left,p,q);
        Node right=lowestCommonAncestor2(root.right,p,q);

        if (left==null) return right;
        else if (right==null) return left;
        else return root; //we have found our answer
    }


}
