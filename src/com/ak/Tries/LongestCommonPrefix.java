package com.ak.Tries;

public class LongestCommonPrefix {
    //now we'll find the longest common prefix
    //so basically the approach is : the largest common prefix is till where branching occurs
    //to tackle the branch problem , I will use a count variable which count the number of branches for a corresponding node and if it is 2 or greater , we'll break
    static int index;
    private static int countBranching(Node node){
        int count=0;
        for (int i = 0; i <26 ; i++) {
            if (node.children[i]!=null) {
                count++;
                index=i;
            }
        }
        return count;
    }
    private static String lcp(Node root){
        Node currNode=root;
        StringBuilder lCP= new StringBuilder();
        index=0;
        while (countBranching(currNode)==1 && !currNode.isTerminal){
             currNode=currNode.children[index];
             lCP.append((char) ('a' + index));
        }
        return lCP.toString();
    }

    public static void main(String[] args) {
        Node root=new Node();
        Tries.insert("ambar",root);
        Tries.insert("ambaala",root);
        Tries.insert("amesterdam",root);

        System.out.println(lcp(root));
    }
}
