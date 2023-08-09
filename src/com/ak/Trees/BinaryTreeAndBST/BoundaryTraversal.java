package com.ak.Trees.BinaryTreeAndBST;

import java.util.ArrayList;

public class BoundaryTraversal {

        boolean isLeaf(Node root) {
            return (root.left == null) && (root.right == null);
        }

        ArrayList<Integer> boundary(Node node) {
            ArrayList<Integer> ans = new ArrayList<>();
            if (!isLeaf(node)) {
                ans.add(node.data);
            }
            leftBoundary(node.left, ans);
            addLeaf(node, ans);
            rightBoundary(node.right, ans);
            return ans;
        }

        // method for exploring the left boundary
        private void leftBoundary(Node node, ArrayList<Integer> ans) {
            Node curr = node;
            while (curr != null) {
                if (!isLeaf(curr)) {
                    ans.add(curr.data);
                }
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }
        }

        private void rightBoundary(Node node, ArrayList<Integer> ans) {
            Node curr = node;
            ArrayList<Integer> rev = new ArrayList<>();
            while (curr != null) {
                if (!isLeaf(curr)) {
                    rev.add(curr.data);
                }
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr = curr.left;
                }
            }

            // add in opposite direction
            int i;
            for (i = rev.size() - 1; i >= 0; --i) {
                ans.add(rev.get(i));
            }
        }

        // method to add the leaf nodes
        private void addLeaf(Node node, ArrayList<Integer> ans) {
            if (isLeaf(node)) {
                ans.add(node.data);
                return;
            }
            if (node.left != null) {
                addLeaf(node.left, ans);
            }
            if (node.right != null) {
                addLeaf(node.right, ans);
            }
        }
    }


