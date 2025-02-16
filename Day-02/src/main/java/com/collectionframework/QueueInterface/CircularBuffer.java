package com.collectionframework.QueueInterface;
import java.util.Arrays;




    class CircularBuffer {
        private int[] buffer;
        private int front, rear, size, capacity;

        public CircularBuffer(int capacity) {
            this.capacity = capacity;
            this.buffer = new int[capacity];
            this.front = 0;
            this.rear = 0;
            this.size = 0;
        }

        // Enqueue (insert element, overwrite if full)
        public void enqueue(int value) {
            if (size == capacity) {
                // Overwrite oldest element
                front = (front + 1) % capacity;
            } else {
                size++;
            }
            buffer[rear] = value;
            rear = (rear + 1) % capacity;
        }

        // Dequeue (remove the oldest element)
        public int dequeue() {
            if (size == 0) {
                throw new IllegalStateException("Buffer is empty!");
            }
            int removedValue = buffer[front];
            front = (front + 1) % capacity;
            size--;
            return removedValue;
        }

        // Peek (view the front element)
        public int peek() {
            if (size == 0) {
                throw new IllegalStateException("Buffer is empty!");
            }
            return buffer[front];
        }

        // Display buffer contents
        public void display() {
            System.out.print("Buffer: ");
            for (int i = 0; i < size; i++) {
                System.out.print(buffer[(front + i) % capacity] + " ");
            }
            System.out.println();
        }

        public static void main(String[] args) {
            CircularBuffer cb = new CircularBuffer(3);

            cb.enqueue(1);
            cb.enqueue(2);
            cb.enqueue(3);
            cb.display(); // Output: Buffer: 1 2 3

            cb.enqueue(4); // Overwrites 1
            cb.display(); // Output: Buffer: 2 3 4

            System.out.println("Dequeued: " + cb.dequeue()); // Output: 2
            cb.display(); // Output: Buffer: 3 4

            cb.enqueue(5);
            cb.display(); // Output: Buffer: 3 4 5
        }
    }


