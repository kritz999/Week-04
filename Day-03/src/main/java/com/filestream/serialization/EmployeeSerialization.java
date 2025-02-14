package com.filestream.serialization;

import java.io.*;
import java.util.*;

// Employee class implementing Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + "}";
    }
}

public class EmployeeSerialization {
    private static final String FILE_NAME = "employees.ser";

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", "HR", 50000));
        employees.add(new Employee(2, "Bob", "IT", 60000));
        employees.add(new Employee(3, "Charlie", "Finance", 55000));

        // Serialize employees
        serializeEmployees(employees);

        // Deserialize and display employees
        List<Employee> deserializedEmployees = deserializeEmployees();
        if (deserializedEmployees != null) {
            System.out.println("Deserialized Employees:");
            for (Employee emp : deserializedEmployees) {
                System.out.println(emp);
            }
        }
    }

    private static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully.");
        } catch (IOException e) {
            System.err.println("Serialization failed: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Employee> deserializeEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Deserialization failed: " + e.getMessage());
        }
        return null;
    }
}
