import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.GroupLayout.Group;

public class EmployeeData2 {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(101, "Pankaj", "IT", 55000, Arrays.asList("Java", "Spring Boot", "MySQL")),
                new Employee(102, "Rahul", "HR", 45000, Arrays.asList("Recruitment", "Communication")),
                new Employee(103, "Priya", "Finance", 60000, Arrays.asList("Accounting", "Excel", "Tally")),
                new Employee(104, "Amit", "IT", 70000, Arrays.asList("Java", "Microservices", "Docker")),
                new Employee(105, "Sneha", "Marketing", 48000, Arrays.asList("SEO", "Content Writing", "Analytics")),
                new Employee(106, "Rohit", "Sales", 52000, Arrays.asList("Negotiation", "CRM", "Lead Generation")),
                new Employee(107, "Neha", "IT", 65000, Arrays.asList("React", "JavaScript", "UI/UX")),
                new Employee(108, "Vikram", "Operations", 58000, Arrays.asList("Process Management", "Supply Chain")),
                new Employee(109, "Anjali", "Finance", 62000, Arrays.asList("Budgeting", "Forecasting")),
                new Employee(110, "Suresh", "Admin", 43000, Arrays.asList("Office Management", "Documentation")));

        // Group employees by department
        Map<String, List<Employee>> emp = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        emp.forEach((key, value) -> {
            value.forEach(v -> System.out.println(v.getName()));
        });

        // Count employees in each department
        Map<String, Long> countDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        System.out.println(countDept);

        // Get total salary of each department
        Map<String, Double> salaryOfEachDepart = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));

        System.out.println("Total salary of each department  : " + salaryOfEachDepart);

        // Get average salary of each department
        Map<String, Double> avgSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        System.out.println("Average salary each department : " + avgSalary);

        // Get Highest paid employees of each deparmtnet
        Map<String, Optional<Employee>> highestPaid = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        highestPaid.forEach((key, value) -> {
            System.out.println(key + " : " + value.get().getName());
        });

        // Get the list of employee names in each department
        Map<String, List<String>> listOfEmpNames = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())));

        listOfEmpNames.forEach((key, values) -> {
            System.out.println(key + " : " + values);
        });

        // Get the count of employees with each skills
        Map<String, Long> countBySkill = employees.stream()
                .flatMap(e -> e.getSkills().stream())
                .collect(Collectors.groupingBy(
                        skill -> skill,
                        Collectors.counting()));

        System.out.println("Count Employees with each skills  : " + countBySkill);

        Map<String, Long> countBySkill1 = employees.stream()
                .flatMap(e -> e.getSkills().stream())
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));

        System.out.println("Count Employees with each skills  : " + countBySkill1);

    }
}
