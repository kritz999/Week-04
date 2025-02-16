package MapInterface;
import java.util.*;


    class Employee {
        String name;
        String department;

        public Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        @Override
        public String toString() {
            return name; // Display only the employee's name
        }
    }

    public class GroupEmployeesByDepartment {
        public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
            Map<String, List<Employee>> departmentMap = new HashMap<>();

            for (Employee emp : employees) {
                departmentMap.computeIfAbsent(emp.department, k -> new ArrayList<>()).add(emp);
            }

            return departmentMap;
        }

        public static void main(String[] args) {
            // Example Employee List
            List<Employee> employees = Arrays.asList(
                    new Employee("Alice", "HR"),
                    new Employee("Bob", "IT"),
                    new Employee("Carol", "HR"),
                    new Employee("David", "IT"),
                    new Employee("Eve", "Finance")
            );

            // Group by Department
            Map<String, List<Employee>> groupedEmployees = groupByDepartment(employees);

            // Print grouped employees
            for (Map.Entry<String, List<Employee>> entry : groupedEmployees.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }


