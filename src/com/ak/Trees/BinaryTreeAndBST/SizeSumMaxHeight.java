package com.ak.Trees.BinaryTreeAndBST;

public class SizeSumMaxHeight {


        public static int size(Node node){
            if(node==null) return 0;
            int ls=size(node.left);
            int rs=size(node.right);
            return ls+rs+1;
        }

        public static int sum(Node node){
            if(node==null) return 0;
            int lSum=sum(node.left);
            int rSum=sum(node.right);
            return lSum+rSum+node.data;
        }

        public static int max(Node node){
            if (node==null) return Integer.MIN_VALUE;
            int lSum=max(node.left);
            int rSum=max(node.right);
            return Math.max(lSum , Math.max(rSum,node.data));
        }

        public static int height(Node node){
            if (node==null) return 0; //for edges -1 , for nodes it will return 0;

            int LHeight=height(node.left);
            int RHeight=height(node.right);
            return Math.max(LHeight,RHeight)+1;

        }
}
