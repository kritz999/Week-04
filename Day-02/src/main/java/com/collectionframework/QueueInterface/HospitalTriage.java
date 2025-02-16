package com.collectionframework.QueueInterface;
import java.util.PriorityQueue;

class Patient implements Comparable<Patient> {
        String name;
        int severity;

        public Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }

        // Sorting in descending order of severity
        @Override
        public int compareTo(Patient other) {
            return Integer.compare(other.severity, this.severity); // Higher severity first
        }

        @Override
        public String toString() {
            return name + " (Severity: " + severity + ")";
        }
    }

    public class HospitalTriage {
        public static void main(String[] args) {
            // Create a priority queue (higher severity first)
            PriorityQueue<Patient> triageQueue = new PriorityQueue<>();

            // Add patients
            triageQueue.add(new Patient("John", 3));
            triageQueue.add(new Patient("Alice", 5));
            triageQueue.add(new Patient("Bob", 2));

            // Process patients in order of severity
            System.out.println("Treatment Order:");
            while (!triageQueue.isEmpty()) {
                System.out.println(triageQueue.poll()); // Treat and remove highest severity patient
            }
        }
    }


