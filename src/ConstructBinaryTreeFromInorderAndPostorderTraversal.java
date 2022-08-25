import java.util.HashMap;
import java.util.Map;

import jdk.jshell.spi.SPIResolutionException;
import utils.ArrayUtils;
import utils.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        var sampleClass = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        var sampleInorder01 = new int[]{9, 3, 15, 20, 7};
        var samplePostorder01 = new int[]{9, 15, 7, 20, 3};
        var result01 = sampleClass.buildTree(sampleInorder01, samplePostorder01);
        var printerClass = new BinaryTreePreorderTraversal();
        var result01List = printerClass.preorderTraversal(result01);
        ArrayUtils.printIntList(result01List);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 1 && postorder.length == 1) {
            return new TreeNode(inorder[0]);
        }

        if (inorder.length != postorder.length) {
            return null;
        }

        Map<Integer, Integer> indexOfInorderNums = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexOfInorderNums.putIfAbsent(inorder[i], i);
        }

        return traverseBuild(inorder, postorder,
                0, inorder.length - 1,
                0, postorder.length - 1,
                indexOfInorderNums);
    }

    private TreeNode traverseBuild(int[] inorder, int[] postorder,
                                   int inorderStartIndex, int inorderEndIndex,
                                   int postorderStartIndex, int postorderEndIndex,
                                   Map<Integer, Integer> indexOfInorderNums) {
        // Base case: Stop condition
        if (inorderStartIndex > inorderEndIndex || postorderStartIndex > postorderEndIndex) {
            return null;
        }

        // 1.) Find root
        int rootValue = postorder[postorderEndIndex];
        TreeNode node = new TreeNode(rootValue);

        final int rootIndex = indexOfInorderNums.get(rootValue);
        final int numsLeft = rootIndex - inorderStartIndex; // To prevent start point is not 0, e.g. right sub tree

        // 2.) Traverse and build left sub-tree
        node.left = traverseBuild(inorder, postorder,
                inorderStartIndex, rootIndex - 1,
                postorderStartIndex,  postorderStartIndex + numsLeft - 1,
                indexOfInorderNums);

        // 3.) Traverse and build right sub-tree
        node.right = traverseBuild(inorder, postorder,
                rootIndex + 1, inorderEndIndex,
                postorderStartIndex + numsLeft,  postorderEndIndex - 1,
                indexOfInorderNums);

        return node;
    }
}
