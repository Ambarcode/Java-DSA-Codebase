package com.ak.Trees.BinaryTreeAndBST;

import java.util.LinkedList;
import java.util.Queue;

public class LineWiseLevelOrderTraversal {
    //we'll use Linewise levelOrder traversal

    private static void lineWiseLevel(Node node){
        if (node==null) return;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            int count=queue.size();
            for (int i = 0; i <count; i++) {
                System.out.print(node.data+" ");
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        Integer[] arr={50,25,12,null,null,37,30,null,null,null,75, 62, null, 70, null,null,87,null,null};
        Node root=new Node();
        root=Node.create(root,arr);
        lineWiseLevel(root);
    }

}
