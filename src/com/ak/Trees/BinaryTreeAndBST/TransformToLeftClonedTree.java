package com.ak.Trees.BinaryTreeAndBST;

public class TransformToLeftClonedTree {
    private static Node leftCloned(Node node){
        if (node==null) return null;
        //sara kaam Post-order m hoga


        Node ln=leftCloned(node.left);
        Node rn=leftCloned(node.right);

        node.left= new Node(node.data,ln,null);
        node.right=rn;
        return node;
    }

    public static void main(String[] args) {
        Integer[] arr={50,25,12,null,null,37,30,null,null,null,75, 62, null, 70, null,null,87,null,null};
        Node root=new Node();
        root=Node.create(root,arr);
        Node newRoot=leftCloned(root);
        Node.print(newRoot);
    }
}
