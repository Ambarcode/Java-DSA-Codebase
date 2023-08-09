package com.ak.Trees.BinaryTreeAndBST;

import java.util.ArrayList;
import java.util.List;

public class PrintKNodesFar {
    public List<Integer> distanceK(Node root, Node target, int k) {
        ArrayList<Node> ans=new ArrayList<>();
        nodeToRootPAth(root,target.data,ans); //it will store all the nodes from the node to root
        List<Integer> sol=new ArrayList<>();
        for(int i=0;i<ans.size();i++){
            printKLevelDown(ans.get(i),k-i,(i==0?null:ans.get(i-1)),sol);
        }
        return sol;
    }

    private static void printKLevelDown(Node node , int k, Node block,List<Integer> sol){
        if (node==null || k<0 || node==block) return;

        if (k==0) sol.add(node.data);

        printKLevelDown(node.left,k-1,block,sol); //to reach till kth level
        printKLevelDown(node.right,k-1,block,sol);
    }
    private static boolean nodeToRootPAth(Node node , int target, ArrayList<Node> ans){
        if(node==null) return false;
        if (node.data==target){
            ans.add(node);
            return true;
        }
        //check in left part
        boolean fInLChild=nodeToRootPAth(node.left,target,ans);
        if (fInLChild){
            ans.add(node);
            return true;
        }

        boolean fInRChild=nodeToRootPAth(node.right,target,ans);
        if (fInRChild){
            ans.add(node);
            return true;
        }

        //we have not found the answer
        return false;

    }
//Now we look at some optimized approach

}
