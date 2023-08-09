package com.ak.Trees.BinaryTreeAndBST;

import java.awt.desktop.AppReopenedEvent;
import java.util.Stack;

public class IterativePrePostIn {

    private static class Pair{
        Node node;
        int state;

        public Pair(Node node , int state){
            this.node=node;
            this.state=state;
        }
    }


    private static void iterativePrePostIn(Node node){
        if(node==null) return;
        Stack<Pair> st=new Stack<>();
        st.push(new Pair(node,1));

        String Pre="";
        String Post="";
        String In="";

        while (!st.isEmpty()){
            Pair top=st.peek();
            if (top.state==1){
                //pre
                Pre+=top.node.data+" ";
                top.state++;
                if (top.node.left!=null){
                    st.push(new Pair(top.node.left,1));
                }
            }else if (top.state==2){
              In+=top.node.data+" ";
              top.state++;
                if (top.node.right!=null){
                    st.push(new Pair(top.node.right,1));
                }
            }else {
               Post+=top.node.data+" ";
               st.pop();
            }
        }
        System.out.println(Pre);
        System.out.println(In);
        System.out.println(Post);
    }

    public static void iterativePre(Node node){
        if (node==null) return;
        Stack<Node> st=new Stack<>();
        Node temp=node;
        while (!st.isEmpty() || temp!=null){
            while (temp!=null){
                System.out.print(temp.data+" ");
                if (temp.right!=null){
                    st.push(temp.right);
                }
                temp=temp.left;
            }
            if (!st.isEmpty()){
                temp=st.pop();
            }
        }
        System.out.println();
     }


    private static void iterativeInorder(Node node){
        if (node==null) return;
        Stack<Node> st=new Stack<>();
        Node temp=node;
        while (!st.isEmpty() || temp!=null){
            while (temp!=null){
                st.push(temp);
                temp=temp.left;
            }
            temp=st.pop();
            System.out.print(temp.data+" ");
            temp=temp.right;
        }
        System.out.println();
    }

    private static void iterativePostOrder(Node node){
        if (node==null) return;
        Stack<Node> st=new Stack<>();
        Node currNode=node;
       //The approach is to go left left left , right right right then print
        while (!st.isEmpty() || currNode!=null){
            if (currNode!=null){
                //push all left
                st.push(currNode);
                currNode=currNode.left;
            }
            else {
                //push right
                Node temp=st.peek().right;
                if (temp==null){
                    temp=st.peek();
                    st.pop();
                    System.out.print(temp.data+ " ");

                    while (!st.isEmpty() && temp==st.peek().right){
                        temp=st.pop();
                        System.out.print(temp.data+" ");
                    }
                }
                else {
                    currNode=temp;
                }
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Integer[] arr={50,25,12,null,null,37,30,null,null,null,75, 62, null, 70, null,null,87,null,null};
        Node root=new Node();
        root=Node.create(root,arr);
        iterativePrePostIn(root);
        iterativePre(root);
        iterativeInorder(root);
        iterativePostOrder(root);
    }
}
