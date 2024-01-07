package com.problems.easy;

import com.problems.common.TreeNode;

public class BTMaxDepth {
    int maxCounter = 0;
    public int maxDepth(TreeNode root) {
        if( root != null){
            int lDepth = maxDepth(root.left);
            int rDepth = maxDepth(root.right);
            if (lDepth < rDepth){
                return rDepth + 1;
            } else{
                return lDepth + 1;
            }
        }
        return 0;
    }
}
