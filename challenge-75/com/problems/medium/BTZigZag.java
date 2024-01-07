package com.problems.medium;

import com.problems.common.TreeNode;

public class BTZigZag {

    private static final String RIGHT_DIRECTION = "right";
    private static final String LEFT_DIRECTION = "left";
    private int counter = 1;
    private int pathLength = 0;

    public int longestZigZag(TreeNode root) {
        traverse(root.left, LEFT_DIRECTION);
        traverse(root.right, RIGHT_DIRECTION);
        return pathLength;
    }

    void traverse(TreeNode x, String direction){
        if(x != null){
            pathLength = Math.max(counter, pathLength);
            if (direction.equals(RIGHT_DIRECTION)) {
                counter++;
                traverse(x.left, LEFT_DIRECTION);
                counter = 1;
                traverse(x.right, RIGHT_DIRECTION);
            } else{
                counter++;
                traverse(x.right, RIGHT_DIRECTION);
                counter = 1;
                traverse(x.left, LEFT_DIRECTION);
            }
        }
    }
}
