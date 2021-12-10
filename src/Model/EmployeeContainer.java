package Model;
import java.util.ArrayList;
import java.util.Iterator;

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
	
public boolean addEmployee(Employee employee) {
		
		return employees.add(employee);
	}
	
	public Employee findById(int id) {
		for(Employee employee : employees) {
			if(employee.getId()==id) {
				return employee;
			}
		}
		return null;
	}
	public ArrayList<Employee> findByName(String name) {      
		ArrayList<Employee> results = new ArrayList<>();
		for (Employee employee : employees) {                 //--------------------------------------------------
			if (employee.getName().toLowerCase().contains(name.toLowerCase())) {
				results.add(employee);
			}
		}
		return results;
	}
	public boolean updateEmployee(int index,String name, int id, double salary, String location, String management) 
	{
		employees.get(index).setName(name);
		employees.get(index).setId(id);
		employees.get(index).setSalary(salary);
		employees.get(index).setLocation(location);
		employees.get(index).setManagement(management);
		return true;
	}
	public boolean removeEmployee(int id) {
		Iterator<Employee> employeeIterator = employees.iterator();  
		
		while(employeeIterator.hasNext()) {
			if(employeeIterator.next().getId() == id) {
				employeeIterator.remove();
				return true;
			}
		}
		return false;
	}
	public int getEmployeeIndex(int id) { 
		int employeeIndex = -1;
		for(int i = 0; i < employees.size(); i++) {
			if(employees.get(i).getId() == id)  
				employeeIndex = i;
		}
		return employeeIndex;
	}
	
	public ArrayList<Employee> getAllEmployees(){
		return employees;
	}
}


