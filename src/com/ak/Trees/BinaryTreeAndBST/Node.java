package com.ak.Trees.BinaryTreeAndBST;

import java.util.Stack;

public class Node {
    public Node left;
    public Node right ;
    public int data;

    public Node(){

    }
    public Node(int data){
        this.data=data;
    }
    public Node(int data , Node left , Node right){
        this.data=data;
        this.left=left;
        this.right=right;
    }

    //To insert element we'll create pair class
    public static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node=node;
            this.state=state;
        }
    }

    public static Node create(Node root, Integer[] arr){
           //Integer[] arr={50,25,12,null,null,37,30,null,null,null,75, 62, null, 70, null,null,87,null,null};
           Node node=new Node(arr[0],null,null);
           //root pair
           Pair rtp=new Pair(node,1);

        Stack<Pair> st=new Stack<>();
        st.push(rtp);
        int indx=0;
        while (!st.isEmpty()){
            Pair top=st.peek();
            if (top.state==1){
                indx++;
                if (arr[indx]!=null){
                   top.node.left=new Node(arr[indx],null,null);
                   Pair lp=new Pair(top.node.left,1);
                    st.push(lp);
                }
                 top.state++;
            }
            else if(top.state==2){
               indx++;
               if (arr[indx]!=null){
                   top.node.right=new Node(arr[indx],null,null);
                   Pair rp=new Pair(top.node.right,1);
                   st.push(rp);
               }
               top.state++;
            }
            else {
                st.pop();
            }
        }
        return node;
    }

    public static void print(Node node){

        //termination case
        if (node==null) return;
        String str="";
        str+=node.left==null? " . " : node.left.data +"";
        str+="<--" + node.data +" -> ";
        str+=node.right==null? " . " : node.right.data +"";
        System.out.println(str);
        print(node.left);
        print(node.right);

    }
    public static void main(String[] args) {
        // array is arranged in preorder,
        Integer[] arr={50,25,12,null,null,37,30,null,null,null,75, 62, null, 70, null,null,87,null,null};
         Node root=new Node();
         root=create(root,arr);
         print(root);
    }

}



