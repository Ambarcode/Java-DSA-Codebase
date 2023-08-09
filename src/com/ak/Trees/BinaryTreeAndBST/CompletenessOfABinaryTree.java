package com.ak.Trees.BinaryTreeAndBST;

import java.util.LinkedList;
import java.util.Queue;

public class CompletenessOfABinaryTree {
    //to check whether a tree is a Complete or not : Key is once you find a null node , you mustn't get any other non-null node from the tree,if there is the return false.
    //we'll use BFS , level order traversal
    //at each node we'll insert element until the nodes become empty ,we'll pop out from the queue , if we got a non-null value , we'll pop it out
    public boolean isCompleteTree(Node root) {
        if (root==null) return true;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node node=queue.poll();

            if (node!=null){
                queue.add(node.left);
                queue.add(node.right);
            }
            else {
                while (!queue.isEmpty()){
                    if (queue.poll()!=null) return false;
                }
            }
        }
        return true;
    }

}
