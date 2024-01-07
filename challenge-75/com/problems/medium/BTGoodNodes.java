package com.problems.medium;

import com.problems.common.TreeNode;

public class BTGoodNodes {

    int counter = 0;
    public int goodNodes(TreeNode root) {
        traverse(root, Integer.MIN_VALUE);
        return counter;
    }

    public void traverse(TreeNode x, int maxSoFar){
        if (maxSoFar <= x.val){
            counter++;
        }
        if (x.left != null){
            traverse(x.left, Math.max(x.val, maxSoFar));
        }
        if(x.right != null){
            traverse(x.right, Math.max(x.val, maxSoFar));
        }

    }
}
