import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeData1 {
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

        // Average salary of all employees
        double avgSalary = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("Average salary : " + avgSalary);

        // Average salary of IT depet
        double avgSalaryOfIT1 = employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT"))
                .mapToDouble(Employee::getSalary)
                .average().getAsDouble();
        System.out.println("Average salary of IT depart : " + avgSalaryOfIT1);

        double avgSalaryOfIT2 = employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT"))
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("Average salary of IT depart : " + avgSalaryOfIT2);

        // Average salary of employees earning more than 50k
        double highestAvgSalaryBy50k = employees.stream()
                .filter(emp -> emp.getSalary() > 58000)
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println("Highest salary : " + highestAvgSalaryBy50k);

        // Average number of skills per employees
        double avgSkills = employees.stream()
                .mapToInt(emp -> emp.getSkills().size())
                .average()
                .orElse(0.0);

        double avgSkills1 = employees.stream()
                .collect(Collectors.averagingDouble(emp -> emp.getSkills().size()));

        System.out.println("Avg salary skills " + avgSkills);
        System.out.println("Avg salary skills " + avgSkills1);

    }
}
