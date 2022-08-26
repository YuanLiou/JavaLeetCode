import java.util.HashMap;
import java.util.Map;

import utils.ArrayUtils;
import utils.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        var sampleInorder01 = new int[]{9, 3, 15, 20, 7};
        var samplePreorder01 = new int[]{3, 9, 20, 15, 7};

        var sampleClass = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        var result01 = sampleClass.buildTree(samplePreorder01, sampleInorder01);

        var printClass = new BinaryTreePreorderTraversal();
        var resultList = printClass.preorderTraversal(result01);
        ArrayUtils.printIntList(resultList);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }

        Map<Integer, Integer> inorderNumOfIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderNumOfIndex.putIfAbsent(inorder[i], i);
        }

        return traverseBuild(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1,
                inorderNumOfIndex);
    }

    private TreeNode traverseBuild(int[] preorder, int preorderStartIndex, int preorderEndIndex,
                                   int[] inorder, int inorderStartIndex, int inorderEndIndex,
                                   Map<Integer, Integer> inorderNumOfIndex) {
        // Base Case
        if (preorderStartIndex > preorderEndIndex || inorderStartIndex > inorderEndIndex) {
            return null;
        }

        // 1) Find Root

        int rootValue = preorder[preorderStartIndex];
        TreeNode node = new TreeNode(rootValue);

        int rootIndex = inorderNumOfIndex.get(rootValue);
        int numsLeft = rootIndex - inorderStartIndex;

        // 2) Find and build left children

        node.left = traverseBuild(preorder, (preorderStartIndex + 1), (preorderStartIndex + numsLeft),
                inorder, inorderStartIndex, rootIndex - 1,
                inorderNumOfIndex);

        // 3) Find and build right children

        node.right = traverseBuild(preorder, (preorderStartIndex + numsLeft + 1), preorderEndIndex,
                inorder, rootIndex + 1, inorderEndIndex,
                inorderNumOfIndex);

        return node;
    }
}
