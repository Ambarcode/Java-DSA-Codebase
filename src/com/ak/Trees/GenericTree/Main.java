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
    //here the work is done in edge post and node post area
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
    //we are taking case for edge , not nodes(if asked about nodes , make height=1)
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


    //Another Approach , using count variable and run the loop till queue the size every time
    private static void levelOrderLineWiseTraversal3(Node node){
        Queue<Node> mQueue=new LinkedList<>();
        mQueue.offer(node);

        while (mQueue.size()>0){
            int countCurrentLevel=mQueue.size();
            for (int i=0;i<countCurrentLevel;i++){
                node=mQueue.remove();
                System.out.print(node.data+" ");
                for (Node child: node.children){
                    mQueue.offer(child);
                }
            }
            System.out.println();
        }
    }

    //Another approach could be to use a pair class , which store node and level
    private static class Pair{
        Node node;
        int level;

        Pair(){
            //default constructor
        }

        Pair(Node node , int level){
            this.node=node;
            this.level=level;
        }
    }
    private static void levelOrderLineWiseTraversal4(Node node){
            Queue<Pair> MainQueue=new ArrayDeque<>();
            MainQueue.offer(new Pair(node,1));
            int level=1;
            while (MainQueue.size()>0){
                Pair p=MainQueue.poll();
                if (p.level>level){
                    level= p.level;
                    System.out.println();
                }
                System.out.print(p.node.data+" ");
                for(Node child: p.node.children){
                    Pair cp=new Pair(child , p.level+1);
                    MainQueue.add(cp);
                }
            }
    }

    //Mirroring a Generic tree
    private static void mirror(Node node){
        //keep faith on inner children
        for(Node child: node.children){
            mirror(child);
        }
        //10 ke niche reverse krna h , vo collection kr dega
        Collections.reverse(node.children);
    }

    //Removing the leaf of the generic tree
    private static void removeLeaf(Node node){
        //Pre-call deletion
        for(int i=node.children.size()-1;i>=0;i--){
            Node child=node.children.get(i);
            if (child.children.size()==0){
                node.children.remove(child);
            }
        }

        for (Node child: node.children){
            removeLeaf(child);
        }
    }

    //Linearize a generic tree
    private static void linearize(Node node){
        for(Node child: node.children){
            linearize(child);
        }

        //we have to attach the last node head to second last tail
        while (node.children.size()>1){
            Node last=node.children.remove(node.children.size()-1);
            Node secLast=node.children.get(node.children.size()-1);
            Node secLastTail=getTail(secLast);
            secLastTail.children.add(last);
        }
    }

    //method to get the tail
    private static Node getTail(Node node){
        while (node.children.size()==1){
            node=node.children.get(0);
        }
        return node;
    }

    //Find an element in generic tree
    private static boolean findElem(Node node, int data){
        if (node.data==data) return true;

        for (Node child: node.children){
            if (findElem(child,data)) return true;
        }
        return false;
    }

    //Node to root path

    private static List<Integer> nodeToRootPath(Node node , int data){
        if (node.data==data){
            List<Integer> list=new ArrayList<>();
            list.add(node.data);
            return list;
        }
        for(Node child: node.children){
            List<Integer> list=nodeToRootPath(child,data);
            if (list.size()>0){
                list.add(node.data);
                return list;
            }
        }
        return new ArrayList<>();
    }

    //Lowest Common Ancestor Of two nodes
    private static int lowestCommonAncestor(Node node , int d1,int d2){
        List<Integer> list1=nodeToRootPath(node,d1);
        List<Integer> list2=nodeToRootPath(node,d2);

        int i=list1.size()-1;
        int j=list2.size()-1;

        while (i>=0 && j>=0 && list1.get(i)==list2.get(j)){
            i--;
            j--;
        }
        i++;
        return list1.get(i);
    }

    //Distance between nodes
    private static int distanceBetweenNodes(Node node , int d1,int d2){
        List<Integer> list1=nodeToRootPath(node,d1);
        List<Integer> list2=nodeToRootPath(node,d2);

        int i=list1.size()-1;
        int j=list2.size()-1;

        while (i>=0 && j>=0 && list1.get(i)==list2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;

        return i+j;
    }

    //Check whether both tree are same shape
    private static boolean sameShape(Node n1 , Node n2){
        //pre-call ka kaam
        if (n1.children.size()!=n2.children.size()){
            return false;
        }
        for(int i=0;i<n1.children.size();i++){
            Node p1=n1.children.get(i);
            Node p2=n2.children.get(i); //corresponding children
            if (!sameShape(p1,p2)) return false;
        }
        return true;
    }

    //Now we'll check are tree mirror similar in shape
    //It's similar to the above code we just have to if the size of children of first node is similar to size of children of last second node and so one
    private static boolean areTreeMirrorInShape(Node n1 , Node n2){
        //pre-call ka kaam
        if (n1.children.size()!=n2.children.size()){
            return false;
        }
        for(int i=0;i<n1.children.size();i++){
            int j=n1.children.size()-1-i;
            Node p1=n1.children.get(i);
            Node p2=n2.children.get(j); //corresponding children
            if (!areTreeMirrorInShape(p1,p2)) return false;
        }
        return true;
    }

    //Now we look at the code which determine whether the tree is symmetric or not
    //Hint: The property of symmetric things are that they are mirror images of each other

    private static boolean  isSymmetric(Node node){
        return areTreeMirrorInShape(node , node);
    }


    //Generic Tree Multisolver
    //Travel and change Strategy
     static int min=Integer.MAX_VALUE;
     static int max=Integer.MIN_VALUE;
     static int height=0;
    static int size=0;
    private static void multisolver(Node node, int depth){
        max=Math.max(node.data,max);
        min=Integer.min(node.data,min);
        size+=1;
        height=Math.max(height,depth);

        for(Node child: node.children){
            multisolver(child,depth+1);
        }
    }


    //Method to get predecessor and successor of a number in tree
    static int predecessor;
    static int successor;
    static int state=0;
    private static void predecessorSuccessor(Node node , int elem){
        //we'll use traverse and change strategy
        //as we know parameters , stay inside stack and vanish on every call whereas data member reside in heap and will remain ii
         if (state==0){
             if (node.data==elem){
                 state=1;
             }
             else predecessor=node.data;
         }
         else if (state==1){
             successor=node.data;
             state=2;
         }

         for(Node child: node.children){
             predecessorSuccessor(child,elem);
         }

    }

    //method to get ceil and floor of a node in generic tree
    static int ceil=Integer.MAX_VALUE; //smaller among the largest value
    static int floor =Integer.MIN_VALUE; //larger among the smallest value

    private static void ceilAndFloor(Node node, int elem){
        if (node.data>elem){
            if (node.data<ceil){
                ceil=node.data;
            }
        }
        if (node.data< elem){
            if (node.data>floor){
                floor=node.data;
            }
        }
        for(Node child: node.children){
            ceilAndFloor(child,elem);
        }
    }

    //Max -Heap Declaration:- PriorityQueue<Integer> pQueue
    //            = new PriorityQueue<Integer>(
    //                Collections.reverseOrder());
    //

    //Kth largest element
    //we'll use the floor and ceil approach
    //floor of infinity is the greatest number in the tree , the floor of the greatest number in the tree is the second greatest and the so one ,
    //we'll repeat this process for k times

    private static int kthLargest(Node node , int k){
        floor=Integer.MIN_VALUE;
        int factor=Integer.MAX_VALUE;

        for (int i=0;i<k;i++){
            ceilAndFloor(node,factor); //will set the floor
            factor=floor;
            //reset the floor
            floor=Integer.MIN_VALUE;
        }
        return factor;
    }


    //method to find node which correspond to maximum sum
    static int msn=0;
    static int ms=0;
    private static int retSumAndCalculateMaxSumSubTree(Node node){
        int sum=0;
        for(Node child: node.children){
            int cs=retSumAndCalculateMaxSumSubTree(child);
            sum+=cs;
        }

        sum=sum+node.data;

        if (sum>ms){
            ms=sum;
            msn=node.data;
        }
        return sum;
    }

    //method to print diameter of generic tree
    //diameter is basically maximum number of edges between any two nodes in a binary tree
    static int diameter=0;
    private static int calculateDiaReturnHeight(Node node){
        int deepest=-1;
        int secondDeepest=-1;
        for(Node child: node.children){
            int currHeight=calculateDiaReturnHeight(child);
            if (currHeight>deepest){
                secondDeepest=deepest;
                deepest=currHeight;
            }
            else if (currHeight>secondDeepest){
                secondDeepest=currHeight;
            }
        }

        if (deepest+secondDeepest+2>diameter){
            diameter=deepest+secondDeepest+2; //2 for the common node of their connection
        }

        deepest+=1; //include the current one
        return deepest;
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
        //levelOrderLineWiseTraversal4(root);
      //  print(root);
//        mirror(root);
//        print(root);
//        System.out.println("-------------");
//        removeLeaf(root);
//        print(root);
//     linearize(root);
//     print(root);
     multisolver(root,0);
        System.out.println("Height:-"+height);
        System.out.println("Max-" + max);
        System.out.println("Min-"+ min);
        System.out.println("Size-"+size);

    }
}
