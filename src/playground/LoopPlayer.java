package playground;

public class LoopPlayer {

    public static void main(String[] args) {
        // They're the same
        var sample = new int[]{9, 7, 5, 3, 1, 2, 4, 6, 8};
        for (int i = sample.length - 1; i >= 0; i--) {
            System.out.println("i--, result: " + sample[i]);
        }

        System.out.println("");
        for (int i = sample.length - 1; i >= 0; --i) {
            System.out.println("--i, result: " + sample[i]);
        }
    }
}
