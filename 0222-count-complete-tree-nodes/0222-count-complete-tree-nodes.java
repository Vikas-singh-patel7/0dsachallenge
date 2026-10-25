
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = 0;
        int right = 0;

        TreeNode l = root;
        TreeNode r = root;

        while(l != null){
            left++;
            l = l.left;
        }

        while(r != null){
            right++;
            r = r.right;
        }

        if(left == right){
            return (int)Math.pow(2, left) - 1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
