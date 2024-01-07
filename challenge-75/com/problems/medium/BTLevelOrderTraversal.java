package com.problems.medium;

import com.problems.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> l = new ArrayList<>();
        if(root == null)
            return new ArrayList<>();
        q.add(root);
        List<Integer> level;
        while (!q.isEmpty()){
            int length = q.size();
            level = new ArrayList<>();
            for (int i=0 ;i < length ; i++){
                TreeNode x = q.poll();
                level.add(x.val);
                if(x.left !=null){
                    q.add(x.left);
                }

                if(x.right != null){
                    q.add(x.right);
                }
            }
            l.add(level);
        }
        return l;
    }
}
