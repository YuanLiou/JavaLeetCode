import utils.TreeNode;

public class FlipEquivalentBinaryTrees {
    public static void main(String[] args) {
    }

    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // This question is about how we traverse the tree
        // There are two conditions help us to check whether these trees are equal after flipping.
        //   1. node01.left == node02.left && node01.right = node02.right  (Basically they're same numbers)
        //   2. node01.left == node02.right && node01.right = node02.left  (they're same numbers after flipping)
        //   return 1 || 2
        // However, we're doing recursively here(DSF here!), we need base case as stop conditions.
        // We know these two conditions are:
        //   1. (They're same) both node01 and node02 are null.
        //   2. (They're not same) only one of nodes are null, or values aren't same.

        // base case
        //  They must be same, they both null
        if (root1 == null && root2 == null) {
            return true;
        }

        //  They must be NOT same, One of them is null, or values in both node are not same.
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }

        // Start traverse tree: DFS
        boolean bothSameNodes = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean flippedSameNodes = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        return bothSameNodes || flippedSameNodes;
    }
}
