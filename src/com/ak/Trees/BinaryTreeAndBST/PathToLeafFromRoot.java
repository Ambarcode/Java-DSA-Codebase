package com.ak.Trees.BinaryTreeAndBST;

public class PathToLeafFromRoot {
    private static void  pathLeafToNode(Node node , String path , int sum , int low , int high){
        //for handling case where there is single child
        if (node==null) return;
        if (node.left==null && node.right==null){
            sum+=node.data;
            if (sum>=low && sum<=high){
                path+=node.data+" ";
                System.out.println(path);
            }
            return;
        }
        pathLeafToNode(node.left,path+node.data+" ",sum+node.data,low,high);
        pathLeafToNode(node.right,path+node.data+" ",sum+node.data,low,high);
    }
}
