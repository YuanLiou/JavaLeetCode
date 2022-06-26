import java.util.HashMap;
import java.util.Map;

public class MostStonesRemovedInSameRowColumn {

    // Union Find data structure
    //   Sample:
    private static class UnionFindHashMap {
        // index, top item index
        private Map<Integer, Integer> parent = new HashMap<>();
        // top item index, rank
        private Map<Integer, Integer> rank = new HashMap<>();

        private int groupCounts = 0;

        // sample stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
        // sample02 stones = [[3,2],[0,0],[3,3],[2,1],[2,3],[2,2],[0,2]]
        public UnionFindHashMap(int[][] stones) {
            // 作為單一 index 使用，要區分 row 和 column
            //  row 可以用負數，只是要 + 1 避免 0
            //  column 也需要避免 0，所以也要 + 1
            //  另一個作法則是 column 加上題目的邊界值
            //    例如 1000，因為上限就是 1000 也不可能遇到重複的值
            for (int[] stone : stones) {
                int row = (stone[0] + 1) * -1;
                int column = stone[1] + 1;
                parent.put(row, row);
                parent.put(column, column);
            }

            groupCounts = parent.size(); // init groupCounts as total node's sum
        }

        // mimic `find` method of UnionFind
        public int findTopParentNodeIndex(int x) {
            // Find a direction to top.
            // See these nodes as a tree, always to find the topest node
            // as representation.
            if (parent.getOrDefault(x, 0) != x) {
                parent.put(x, findTopParentNodeIndex(parent.getOrDefault(x, 0)));
            }
            return parent.getOrDefault(x, 0);
        }

        // uses union by rank
        public void union(int x, int y) {
            int xRoot = findTopParentNodeIndex(x);
            int yRoot = findTopParentNodeIndex(y);

            if (xRoot == yRoot) {
                // They're in the same group
                return;
            }

            groupCounts--;

            // Doing union
            if (rank.getOrDefault(xRoot, 0) < rank.getOrDefault(yRoot, 0)) {
                parent.put(xRoot, yRoot);
            } else if (rank.getOrDefault(xRoot, 0) > rank.getOrDefault(yRoot, 0)) {
                parent.put(yRoot, xRoot);
            } else {
                parent.put(xRoot, yRoot);
                rank.put(yRoot, rank.getOrDefault(yRoot, 0) + 1);
            }
        }

        public int getGroupCounts() {
            return groupCounts;
        }
    }

    public static void main(String[] args) {
        // [[3,2],[0,0],[3,3],[2,1],[2,3],[2,2],[0,2]]
        var sample01 = new int[][] {
            {3, 2},
            {0, 0},
            {3, 3},
            {2, 1},
            {2, 3},
            {2, 2},
            {0, 2}
        };

        // sample stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
        var sample02 = new int[][] {
            {0, 0},
            {0, 1},
            {1, 0},
            {1, 2},
            {2, 1},
            {2, 2}
        };
        var result = removeStones(sample01);
        System.out.println("Result is " + result);
    }

    public static int removeStones(int[][] stones) {
        UnionFindHashMap unionFindHashMap = new UnionFindHashMap(stones);
        for (int[] stone : stones) {
            int row = (stone[0] + 1) * -1;
            int column = stone[1] + 1;
            unionFindHashMap.union(row, column);
        }

        return stones.length - unionFindHashMap.groupCounts;
    }
}
