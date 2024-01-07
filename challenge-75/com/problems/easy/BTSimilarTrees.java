package com.problems.easy;

import com.problems.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BTSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1LeafNodes = new ArrayList<>();
        traverse(root1, root1LeafNodes);
        List<Integer> root2LeafNodes = new ArrayList<>();
        traverse(root2, root2LeafNodes);
        return root1LeafNodes.equals(root2LeafNodes);
    }

    public void traverse(TreeNode x, List<Integer> leafNodes){
        if (x != null) {
            if (x.left == null && x.right == null) {
                leafNodes.add(x.val);
            } else {
                traverse(x.left, leafNodes);
                traverse(x.right, leafNodes);
            }
        }
    }
}
