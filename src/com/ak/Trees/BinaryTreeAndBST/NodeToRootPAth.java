package com.ak.Trees.BinaryTreeAndBST;

import java.util.ArrayList;
import java.util.List;

public class NodeToRootPAth {
    static ArrayList<Integer> ans;
    private static boolean nodeToRootPAth(Node node , int target, ArrayList<Integer> ans){
        if(node==null) return false;
        if (node.data==target){
            ans.add(node.data);
            return true;
        }
        //check in left part
        boolean fInLChild=nodeToRootPAth(node.left,target,ans);
        if (fInLChild){
            ans.add(node.data);
            return true;
        }

        boolean fInRChild=nodeToRootPAth(node.right,target,ans);
        if (fInRChild){
            ans.add(node.data);
            return true;
        }

        //we have not found the answer
        return false;

    }

    public static void main(String[] args) {
        Integer[] arr={50,25,12,null,null,37,30,null,null,null,75, 62, null, 70, null,null,87,null,null};
        Node root=new Node();
        root=Node.create(root,arr);
        ans=new ArrayList<>();
        nodeToRootPAth(root,70,ans);
        System.out.println(ans);

    }
}
