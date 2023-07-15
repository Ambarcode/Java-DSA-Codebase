package com.ak.Tries;
class Node{
    Node[] children;
    boolean isTerminal; //to mark whether the current node is a terminal or not

    public Node(){
        children= new Node[2];
        for (int i = 0; i <2 ; i++) {
            children[i]=null;
        }
    }
}

class Trie{
    private static Node root=null;

    public Trie(){
        root=new Node();
    }

    //insert a node
       void insert(int elem){
        Node node=root;
        for (int i=31;i>=0;i--){
            int bit=(elem>>i)&1;
            if (node.children[bit]==null){
                node.children[bit]=new Node();
            }
            node=node.children[bit];
        }
    }

       int maxXor(int elem){
        Node node=root;
        int maxNum=0;
        for (int i=31;i>=0;i--){
            int bit=(elem>>i)&1;
            if (node.children[1-bit]!=null){
                maxNum=maxNum|(1<<i);
                node=node.children[1-bit];
            }
            else node=node.children[bit];
        }
        return maxNum;
    }
}

public class MaximumXorOFTwoNumbers {

    public static int findMaximumXOR(int[] nums) {
        int maxOr=0;
        Trie t=new Trie();
        for (int elem: nums){
            t.insert(elem);
        }

        //now considering each element as x and finding Maximum Xor
        for(int elem: nums){
            maxOr=Math.max(maxOr,t.maxXor(elem));
        }
        return maxOr;
    }

    public static void main(String[] args) {
        int[] nums={3,10,5,25,2,8};
        System.out.println(findMaximumXOR(nums));
    }

}
