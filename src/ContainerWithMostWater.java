public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] sample001 = new int[]{1,8,6,2,5,4,8,3,7};
        int result = maxArea02(sample001);
        System.out.println("result is " + result);
    }

    public static int maxArea02(int[] height) {
        // 直接選取兩個 index，一個在 0，一個在 height.length - 1
        // 算出所佔面積，存在 result
        // 兩個 index 對比，移動比較小的那個 (如果一樣長，移動右邊的 [可任意]）
        // 算出所佔面積， result = Math.max(result, height[i] * height[j])

        int indexI = 0;
        int indexJ = height.length - 1;

        final int currentHorizontalSize = (indexJ - indexI);
        final int currentVerticalSize = Math.min(height[indexI], height[indexJ]);

        int result = Math.max(0, currentHorizontalSize * currentVerticalSize);
        while (indexI != indexJ) {
            // the right bound is larger than the left bound
            if (height[indexI] < height[indexJ]) {
                indexI++;
            } else {
                indexJ--;
            }

            // update the result size
            final int horizontalSize = (indexJ - indexI);
            final int verticalSize = Math.min(height[indexI], height[indexJ]);
            result = Math.max(result, horizontalSize * verticalSize);
        }
        return result;
    }

    public static int maxArea01(int[] height) {
        // 兩個 Pointer x, y
        // 窮舉所有的選擇
        // result = Math.max(result, length * min(area[x], area[y])
        if (height.length == 0 || height.length == 1) {
            return 0;
        }

        int indexI = 0;
        int indexJ = 1;

        int result = Integer.MIN_VALUE;

        // pick the two numbers
        while (indexI < height.length) {
            while (indexJ < height.length) {
                int verticalSize = Math.min(height[indexI], height[indexJ]);
                int horizontalSize = indexJ - indexI;
                result = Math.max(result, verticalSize * horizontalSize);
                indexJ++;
            }

            indexI++;
            indexJ = indexI + 1;
        }
        return result;
    }
}
