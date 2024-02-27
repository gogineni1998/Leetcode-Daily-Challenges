
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int maxDiameter(TreeNode root, int[] diameter) {
        if (root == null) {
            return 0;
        }
        int left = maxDiameter(root.left, diameter);
        int right = maxDiameter(root.right, diameter);
        diameter[0] = Integer.max(diameter[0], left + right);
        return 1 + Integer.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        diameter[0] = Integer.MIN_VALUE;
        maxDiameter(root, diameter);
        return diameter[0];
    }
}