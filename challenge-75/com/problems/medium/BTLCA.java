package com.problems.medium;

import com.problems.common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BTLCA {

    private final Map<TreeNode, TreeNode> parentsMap = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        parentsMap.put(root, null);
        dfs(root, p, q);
        Set<TreeNode> ancestors = new HashSet<>();

        while (p != null){
            ancestors.add(p);
            p = parentsMap.get(p);
        }

        while (!ancestors.contains(q)){
            q = parentsMap.get(q);
        }
        return q;
    }

    public void dfs(TreeNode x, TreeNode p, TreeNode q){
        if(x!=null ){
            if(x.left != null){
                parentsMap.put(x.left, x);
                dfs(x.left, p, q);
            }
            if (x.right != null) {
                parentsMap.put(x.right, x);
                dfs(x.right, p, q);
            }
        }
    }
}
