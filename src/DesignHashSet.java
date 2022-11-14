public class DesignHashSet {
	private static final int SIZE = (int) Math.pow(10, 6) + 1;
	private boolean[] contents = new boolean[SIZE];

	public DesignHashSet() {
    }

    public void add(int key) {
		contents[key] = true;
    }

    public void remove(int key) {
	    contents[key] = false;
    }

	public boolean contains(int key) {
		return contents[key];
    }
}
