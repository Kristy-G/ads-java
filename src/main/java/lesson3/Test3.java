package lesson3;

import lesson3.queue.PriorityQueueImpl;
import lesson3.queue.Queue;
import lesson3.queue.QueueImpl;
import lesson3.stack.Stack;
import lesson3.stack.StackImpl;
import lesson4.LinkedListStack;
import lesson4.LinkedQueueImpl;

public class Test3 {

    public static void main(String[] args) {
//        testStack();
        testQueue();
    }

    private static void testStack() {
//        Stack<Integer> stack = new StackImpl<>(5);
        Stack<Integer> stack = new LinkedListStack<>();
        if (!stack.isEmpty()) {
            stack.pop();
        }
        addToStack(stack, 12);
        addToStack(stack, 16);
        addToStack(stack, 22);
        addToStack(stack, 5);
        addToStack(stack, 1);
        addToStack(stack, 32);

        stack.display();

        System.out.println("top value: " + stack.pop() );
        System.out.println("top value: " + stack.peek() );
        stack.display();
    }

    private static boolean addToStack(Stack<Integer> stack, int value) {
        if (!stack.isFull()) {
            stack.push(value);
            return true;
        }
        return false;
    }

    private static void testQueue() {
//        Queue<Integer> queue = new QueueImpl<>(5);
//        Queue<Integer> queue = new PriorityQueueImpl<>(5);
        Queue<Integer> queue = new LinkedQueueImpl<>();
        System.out.println("add element: " + queue.insert(34));
        System.out.println("add element: " + queue.insert(12));
        System.out.println("add element: " + queue.insert(20));
        System.out.println("add element: " + queue.insert(16));
        System.out.println("add element: " + queue.insert(14));
        System.out.println("add element: " + queue.insert(17));

        queue.display();
        System.out.println("remove: " + queue.remove());
        queue.display();

    }

}
