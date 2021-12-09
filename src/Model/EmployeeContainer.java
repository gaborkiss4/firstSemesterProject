package Model;
import java.util.ArrayList;

public class EmployeeContainer {
	private static EmployeeContainer instance;
	private ArrayList<Employee> employees;
	
	private EmployeeContainer() {
		employees = new ArrayList<>();
	}
	
	public static EmployeeContainer getInstance() {
		if(instance == null) {
			instance = new EmployeeContainer();
		}
		return instance;
	}
	
	public void addEmployee(String name, int id, int salary, String location, boolean management) {
		employees.add(new Employee(name, id, salary, location, management));
	}
	
	public Employee searchById(int id) {
		for(Employee i : employees) {
			if(i.getId()==id) {
				return i;
			}
		}
		return null;
	}
}
