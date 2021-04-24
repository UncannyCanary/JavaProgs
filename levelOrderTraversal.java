package JavaProgs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
   TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
   }
}

class levelOrderTraversal {

    public static void main(String[] args) {
        TreeNode v1 = new TreeNode(15);
        TreeNode v2 = new TreeNode(7);
        TreeNode v3 = new TreeNode(20, v1, v2);
        TreeNode v5 = new TreeNode(13);
        TreeNode v6 = new TreeNode(12);
        TreeNode v4 = new TreeNode(9, v5, v6);
        TreeNode root = new TreeNode(3, v4, v3);
        System.out.println(levelOrder(root));
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> d = new ArrayDeque<>();
        d.add(root);
        int i = 0;
        int tempCount = 0;
        while(!d.isEmpty()) {
            TreeNode node = d.poll();
            int count = 1 << i;
            if (tempCount != count) {
                temp.add(node.val);
                tempCount++;
                if (tempCount == count) {
                    tempCount = 0;
                    i++;
                }
            }
            if(node.left != null){d.add(node.left);} 
            if (node.right != null){d.add(node.right);} 
            if (tempCount == 0) {
                result.add(new ArrayList<>(temp));
                temp.clear();
            }    
        }
        return result;
    }
}

