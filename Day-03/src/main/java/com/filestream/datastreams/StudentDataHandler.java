package com.filestream.datastreams;
import java.io.*;


    public class StudentDataHandler {
        public static void main(String[] args) {
            String filePath = "student_data.bin";

            // Store student details
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
                dos.writeInt(101); // Roll Number
                dos.writeUTF("John Doe"); // Name
                dos.writeDouble(3.75); // GPA
                System.out.println("Student data stored successfully.");
            } catch (IOException e) {
                System.err.println("Error writing data: " + e.getMessage());
            }

            // Retrieve student details
            try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Retrieved Student Details:");
                System.out.println("Roll Number: " + rollNumber);
                System.out.println("Name: " + name);
                System.out.println("GPA: " + gpa);
            } catch (IOException e) {
                System.err.println("Error reading data: " + e.getMessage());
            }
        }
    }



