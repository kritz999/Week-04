package com.collectionframework.QueueInterface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

        public class reverseQueue {
            public static void reverseQueue(Queue<Integer> queue) {
                Stack<Integer> stack = new Stack<>();

                // Step 1: Remove elements from queue and push onto stack
                while (!queue.isEmpty()) {
                    stack.push(queue.poll());
                }

                // Step 2: Pop from stack and add back to queue
                while (!stack.isEmpty()) {
                    queue.add(stack.pop());
                }
            }

            public static void main(String[] args) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(10);
                queue.add(20);
                queue.add(30);

                System.out.println("Original Queue: " + queue);
                reverseQueue(queue);
                System.out.println("Reversed Queue: " + queue);
            }
        }

    }

