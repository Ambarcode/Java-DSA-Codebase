package com.ak.Trees.BinaryTreeAndBST;

import java.util.ArrayList;
import java.util.HashMap;


public class VerticalSum {
    public ArrayList<Integer> verticalSum(Node A) {
        ArrayList<Integer> ans = new ArrayList<>();
        //Remember in TreeMap keys are maintained in sorted order, and it does not contain null keys
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] minMax = {0, 0}; // Store min at index 0, and max at index 1
        help(A, map, 0, minMax);

        for (int i = minMax[0]; i <= minMax[1]; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }

    private void help(Node node, HashMap<Integer, Integer> map, int hd, int[] minMax) {
        if (node == null) return;
        if (!map.containsKey(hd)) {
            map.put(hd, node.data);
        } else {
            map.put(hd, map.get(hd) + node.data);
        }

        // Update minMax with the current horizontal distance (hd)
        minMax[0] = Math.min(hd, minMax[0]);
        minMax[1] = Math.max(hd, minMax[1]);

        help(node.left, map, hd - 1, minMax);
        help(node.right, map, hd + 1, minMax);
    }
}
