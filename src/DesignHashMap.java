import java.util.Arrays;

public class DesignHashMap {

	private static final int SIZE = (int) Math.pow(10, 6) + 1;
	private int[] contents = new int[SIZE];

	public DesignHashMap() {
		Arrays.fill(contents, -1);
    }

    public void put(int key, int value) {
		contents[key] = value;
    }

    public int get(int key) {
		return contents[key];
    }

    public void remove(int key) {
		contents[key] = -1;
    }
}
