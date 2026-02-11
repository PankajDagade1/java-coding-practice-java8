import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeData {

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

        // collectors.summingDouble

        // Total salary of all employees
        double totalSalary1 = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();

        double totalSalary2 = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));

        System.out.println("Salary : " + totalSalary1);
        System.out.println("Salary : " + totalSalary2);

        // Total Salary of IT department
        double itSalaryTotal = employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT"))
                .collect(Collectors.summingDouble(Employee::getSalary));

        System.out.println("Total salary of IT Department : " + itSalaryTotal);

        double itSalaryTotal1 = employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT"))
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Total salary of IT Department : " + itSalaryTotal1);

        // Total salary of employees earning more than 80k(filtered analytics)
        double highTotalSalary = employees.stream()
                .filter(emp -> emp.getSalary() > 58000)
                .collect(Collectors.summingDouble(Employee::getSalary));

        double highTotalSalary1 = employees.stream()
                .filter(emp -> emp.getSalary() > 58000)
                .mapToDouble(Employee::getSalary)
                .sum();

        System.out.println("Total salary earning more than 58k : " + highTotalSalary);
        System.out.println("Total salary earning more than 58k : " + highTotalSalary1);

        // Total number of skills across all employees
        int totalSkills = employees.stream()
                .collect(Collectors.summingInt(emp -> emp.getSkills().size()));

        System.out.println("Total number of skills : " + totalSkills);

        // Total skills among IT employees
        int itTotalSkills = employees.stream()
                .filter(skill -> skill.getDepartment().equals("IT"))
                .collect(Collectors.summingInt(emp -> emp.getSkills().size()));

        System.out.println("IT total skills : " + itTotalSkills);

        // Total Traning cost of all skills of IT employees
        int traningCost = employees.stream()
                .filter(skill -> skill.getDepartment().equals("IT"))
                .collect(Collectors.summingInt(emp -> emp.getSkills().size() * 200));

        System.out.println("IT total Traning cost : " + traningCost);

        // Total bonus payout (10% salary)
        double totalBonus = employees.stream()
                .collect(Collectors.summingDouble(emp -> emp.getSalary() * 0.10));

        System.out.println("Total Bonus : " + totalBonus);

    }
}
