package com.ak.Trees.GenericTree;

import java.util.*;

public class Main {
    private static class Node{
        int data;
        ArrayList<Node> children =new ArrayList<>();
    }


    //d(10) -> 10 will print itself, and it's family
    //d(20) , d(30) , d(40) will print themselves and their families(refer to notebook)
    //d(10)=s(10)+d(20)+d(30)+d(40)
    //Initialize a String str = node.data + "-> ".
    //Run a for loop for all the children and append child.data and "," to the string.
    //Finally, append "." to the string and print the result.
    //Now, recursively call the display function for all the children nodes.
    public static void print(Node node){
        StringBuilder str= new StringBuilder(node.data + " --> ");
        for(Node child: node.children){
            str.append(child.data).append(" , ");
        }
        str.append(".");
        System.out.println(str);
        for(Node child: node.children){
            print(child);
        }
    }

    //to get the number of elements from the generic tree

    public static int size(Node node){
        int s=0;
        for(Node child: node.children){
            int cs=size(child);
            s+=cs;
        }
        s+=1;
        return s;
    }

    //To get the maximum element from the generic tree
    private static int max(Node node){
        int max=Integer.MIN_VALUE;
        for(Node child: node.children){
            int cm=max(child);
            max=Math.max(cm,max);
        }
        max=Math.max(max,node.data);
        return max;
    }

     //to get the height of generic tree
    public static int height(Node node){
        int height=-1;
        for (Node child: node.children){
            int commHeight=height(child);
            height=Math.max(commHeight,height);
        }
        return height+1;
    }
    
    //now we'll look at some traversals
    //general traversal -i.e. preorder and postorder\
    private static void traversal(Node node){
        //Euler's left path , On the way to deep recursion -Node pre
        System.out.println("Node Pre -" + node.data);
        for(Node child: node.children){
            //Edge Pre
            System.out.println("Edge Pre "+ node.data+"---"+child.data);
            traversal(child);
            //edge post
            System.out.println("Edge Post "+ node.data+"---"+child.data);
        }
        //Euler's Right path , while coming out of the deep recursion-Node post
        System.out.println("Node Post-" +node.data);
    }

    //level-order traversal

    private static void levelOrder(Node node){
        Queue<Node> queue=new ArrayDeque<>();
        queue.offer(node);
        while (queue.size()>0){
            //remove
            Node n=queue.poll();
            //print
            System.out.println(n.data);
            //add
            for (Node child: n.children){
                queue.offer(child);
            }
        }
        System.out.println(".");
    }

    //Now we'll see level order line wise traversal i.e. each node is print in next line

    private static void levelOrderLineWiseTraversal(Node node){
        Queue<Node> mainQ=new ArrayDeque<>();
        mainQ.offer(node);
        Queue<Node> childQ=new ArrayDeque<>();
        while (mainQ.size()>0){
            node=mainQ.poll();
            System.out.print(node.data+" ");

            //push into child queue
            for (Node child: node.children){
                childQ.offer(child);
            }

            if (mainQ.size()==0){
                mainQ=childQ;
                childQ=new ArrayDeque<>();
                System.out.println();
            }
        }
        System.out.println(".");
    }

    private static void zigZagLevelOrder(Node node){
        //for this we'll use two stacks
        //if level is odd , we'll insert the node from left to right else right to left
        Stack<Node> mainS=new Stack<>();
        mainS.push(node);
        Stack<Node> childS=new Stack<>();
        int level=1;
        while (mainS.size()>0){
            node=mainS.pop();
            System.out.print(node.data+" ");

            if (level%2==1){
                for (int i = 0; i <node.children.size() ; i++) {
                    childS.push(node.children.get(i));
                }
            }
            else{
              for(int i=node.children.size()-1;i>=0;i--){
                  childS.push(node.children.get(i));
              }
            }

            if (mainS.isEmpty()){
                mainS=childS;
                level++;
                childS=new Stack<>();
            }
        }
        System.out.print(".");

    }

    //Now we'll look into another approach of linewiseInorder traversal without using child queue
    private static void levelOrderLineWiseTraversal2(Node node){

    //Remember ArrayDeque does not allow null values
    Queue<Node> mQueue=new LinkedList<>();
        mQueue.add(node);
        mQueue.add(null);
        while (mQueue.size()>0){
            node=mQueue.poll();
            if (node!=null){
                System.out.print(node.data+" ");
                for (Node elem: node.children) {
                    mQueue.offer(elem);
                }
            }
            else {
                if (mQueue.size()>0){
                    mQueue.add(null);
                    System.out.println();
                }
            }
        }
    }




    public static void main(String[] args) {
        //the approach is to use stack and each time an element is encountered(not -1) , we'll make it a children of element which is present at the top and if the traversed element is -1 pop the node from the stack
        int[] arr={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root=null;
        Stack<Node> st=new Stack<>();
        for (int j : arr) {
            if (j == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = j;
                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }
                st.push(t);
            }
        }
//        print(root);
//        System.out.println(height(root));
//        System.out.println(max(root));
//        traversal(root);
        //levelOrder(root);
        //levelOrderLineWiseTraversal(root);
        //zigZagLevelOrder(root);
        levelOrderLineWiseTraversal2(root);
    }
}
