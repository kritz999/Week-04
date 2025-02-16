package com.collectionframework.QueueInterface;
import java.util.LinkedList;
import java.util.Queue;


    class StackUsingQueues {
        private Queue<Integer> q1 = new LinkedList<>();
        private Queue<Integer> q2 = new LinkedList<>();

        // Push element onto stack
        public void push(int x) {
            q2.add(x); // Add new element to q2

            // Transfer all elements from q1 to q2
            while (!q1.isEmpty()) {
                q2.add(q1.poll());
            }

            // Swap q1 and q2
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        // Removes and returns the top element
        public int pop() {
            if (q1.isEmpty()) {
                throw new IllegalStateException("Stack is empty!");
            }
            return q1.poll();
        }

        // Returns the top element without removing it
        public int top() {
            if (q1.isEmpty()) {
                throw new IllegalStateException("Stack is empty!");
            }
            return q1.peek();
        }

        // Checks if the stack is empty
        public boolean isEmpty() {
            return q1.isEmpty();
        }

        public static void main(String[] args) {
            StackUsingQueues stack = new StackUsingQueues();
            stack.push(1);
            stack.push(2);
            stack.push(3);

            System.out.println("Top Element: " + stack.top()); // Output: 3
            System.out.println("Popped: " + stack.pop()); // Output: 3
            System.out.println("Popped: " + stack.pop()); // Output: 2
        }
    }


