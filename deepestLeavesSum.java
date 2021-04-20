package JavaProgs;
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
 
class deepestLeavesSum {
    public static void main(String[] args) {
        TreeNode seven = new TreeNode(7, null, null);
        TreeNode eight = new TreeNode(8, null, null);
        TreeNode four = new TreeNode(4, seven, null);
        TreeNode five = new TreeNode(5, null, null);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode six = new TreeNode(6, null, eight);
        TreeNode three = new TreeNode(3, null, six);
        TreeNode root = new TreeNode(1, two, three);
        System.out.println(deepestLeavesSumm(root));
    }
    public static int deepestLeavesSumm(TreeNode root) {
        int maxDepth = getMaxDepth(root);
        return sumOfDeepestLeaves(root, maxDepth - 1);
    }
    
    private static int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lHeight = getMaxDepth(root.left);
        int rHeight = getMaxDepth(root.right);
        if (lHeight > rHeight) {
            return 1 + lHeight;
        }
        else {
            return 1 + rHeight;
        }
    }
    
    private static int sumOfDeepestLeaves(TreeNode node, int depth) {
        if (node == null) {
            return 0;
        }
        if (depth == 0) {
            return node.val;
        }
        int val1 = sumOfDeepestLeaves(node.left, depth - 1);
        int val2 = sumOfDeepestLeaves(node.right, depth - 1);
        return val1 + val2;
    }
}