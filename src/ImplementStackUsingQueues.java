import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    public static void main(String[] args) {
    }

    public ImplementStackUsingQueues() {
    }

    Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        // One Queue: Swap element from Tail to Head
        queue.offer(x);

        // Swap element, push the tail to the head
        //  1, 2, [5], 4. Supposed we're in step 3
        //      Tail -~~~~> Head   (For easily visualize)
        //  Queue  [       ]       , Element in the right size would be pushed out first.
        //
        //  [1, 2]  -> We get 2, 1 in result to mimic Stack
        //
        // We're current in step 3
        // offer 5
        //  [5, 1, 2] -> We get 2, 1, 5
        //
        // swap head to tail
        //  [2, 5, 1]
        //  [1, 2, 5] -> We get 5, 2, 1
        // ==== ==== ==== ==== ==== ==== ==== ==== ====
        //  [1, 2, 5] -> We get 5, 2, 1 in result to mimic Stack
        // 1, 2, 5, [4]. Suppose we're in step 4
        // offer 4
        //  [4, 1, 2, 5] -> We get 5, 2, 1, 4
        //
        // swap head to tail
        //  [5, 4, 1, 2]
        //  [2, 5, 4, 1]
        //  [1, 2, 5, 4] -> We get 4, 5, 2, 1
        int currentSize = queue.size();
        while (currentSize > 1) {
            queue.offer(queue.poll());
            currentSize--;
        }
    }

    public void push002(int x) {
        // Dual Queue
        if (queue.isEmpty()) {
            queue.offer(x);
        } else {
            Queue<Integer> anotherQueue = new LinkedList<>();
            anotherQueue.offer(x);

            while (!queue.isEmpty()) {
                anotherQueue.offer(queue.poll());
            }
            queue = anotherQueue;
        }
    }

    public int pop() {
        if (queue.isEmpty()) {
            return 0;
        }
        return queue.poll();
    }

    public int top() {
        if (queue.isEmpty()) {
            return 0;
        }
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
