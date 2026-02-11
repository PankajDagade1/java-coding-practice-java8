import java.util.List;

public class Employee1 {
	
	private int empId;
    private String name;
    private String department;
    private double salary;
    private List<String> skills;
    
	public Employee() {
		super();
	}

	public Employee(int empId, String name, String department, double salary, List<String> skills) {
		super();
		this.empId = empId;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.skills = skills;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
}
