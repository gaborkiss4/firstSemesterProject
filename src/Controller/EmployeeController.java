package Controller;
import java.util.ArrayList;
import Model.Employee;
import Model.EmployeeContainer;
public class EmployeeController {

	private static EmployeeController instance = new EmployeeController();
	private EmployeeContainer employeeContainer;
	
	private EmployeeController() {
		employeeContainer = EmployeeContainer.getInstance();
	}
	
	public static EmployeeController getInstance() {
		return instance;
	}
	
	public ArrayList<Employee> findByName(String name) {
		
		return EmployeeContainer.getInstance().findByName(name); 
	}
	public ArrayList<Employee> getAllEmployees() {
		
		return EmployeeContainer.getInstance().getAllEmployees(); 
	}
	
	
	
	public Employee findById(int id) { 
	
		return EmployeeContainer.getInstance().findById(id); 
	}
	
	public boolean createEmployee(String name, int id, int salary, String location, String management) {
		
		if(EmployeeContainer.getInstance().findById(id) == null)
			return EmployeeContainer.getInstance().addEmployee(new Employee(name, id, salary, location, management));
		return false;
	}
	
	public boolean updateEmployee(int oldId, String name,int id,int salary,String location,String management) {
	
		int employeeIndex = employeeContainer.getEmployeeIndex(oldId);
		
		String newName = name == "" ? employeeContainer.getAllEmployees().get(employeeIndex).getName() : name;
		int newId = id == 0 ? employeeContainer.getAllEmployees().get(employeeIndex).getId() : id;
		double newSalary= salary== 0 ? employeeContainer.getAllEmployees().get(employeeIndex).getSalary() : salary;  
		String newLocation = location == "" ? employeeContainer.getAllEmployees().get(employeeIndex).getLocation() : location;
		String newManagement = management == "" ? employeeContainer.getAllEmployees().get(employeeIndex).getManagement() : management;                      
		
		
		
	
		if(employeeContainer.findById(newId)!= null && oldId!= newId) { 
			return false;
		}
		
		
		return EmployeeContainer.getInstance().updateEmployee(employeeIndex, newName,newId, newSalary, newLocation,newManagement);
	}
	
	public boolean deleteEmployee(int Id) {
		return EmployeeContainer.getInstance().removeEmployee(Id);
	}
	
}
	
	
	