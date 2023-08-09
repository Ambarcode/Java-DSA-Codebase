package com.ak.Trees.BinaryTreeAndBST;

import java.util.*;

public class zigZagTraversal {
    //To do the zigzag traversal we'll use queue data structure
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue <Node> que = new LinkedList<>();
        boolean evenOdd=true;
        que.offer(root);
        while(que.size()>0){
            int n=que.size();
            List<Integer> temp= new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                if (que.peek().left != null) que.offer(que.peek().left);
                if (que.peek().right != null) que.offer(que.peek().right);
                if(evenOdd) temp.add(que.poll().data);
                else temp.add(0,que.poll().data); //to add in reverse order

            }
            evenOdd=!evenOdd;
            ans.add(temp);
        }

        return ans;
    }
}
