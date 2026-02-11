import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main1 {

    public static void main(String[] args) {
        
    List<Employee> employees = Arrays.asList(
        new Employee(1, "Rahul", "Male", "IT", 50000),
        new Employee(2, "Priya", "Female", "HR", 45000),
        new Employee(3, "Amit", "Male", "Finance", 60000),
        new Employee(4, "Sneha", "Female", "IT", 55000),
        new Employee(5, "Vikas", "Male", "Sales", 48000),
        new Employee(6, "Anita", "Female", "Marketing", 52000),
        new Employee(7, "Rohit", "Male", "HR", 47000),
        new Employee(8, "Neha", "Female", "Finance", 61000),
        new Employee(9, "Suresh", "Male", "IT", 65000),
        new Employee(10, "Pooja", "Female", "Sales", 46000)
     );

     /* Highest Salary */

    Optional<Employee> opc = employees.stream()
              .max(Comparator.comparingDouble(Employee::getSalary));

    System.out.println("Highest salary employee: "+opc.get().getName());


    }
}
