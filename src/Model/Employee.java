package Model;

public class Employee {
	private String name;
	private int id;
	private double salary;
	private Employee boss;
	private String location;
	private String management;
	
	
	
	public Employee(String name, int id, double salary, String location, String management) {
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.location = location;
		this.management = management;
		
	}
	public void setName(String name) {
		
		this.name= name;
		
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setSalary(double salary) {
		
		this.salary = salary;
		
	}
	public double getSalary() {
		return salary;
	}
	
	public Employee getBoss() {
		return boss;
	}
	
	public void setBoss(Employee e) {
		this.boss = e;
	}
	
	public void setLocation(String location) {
		
		this.location= location;
		
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setManagement(String management) {
		
		this.management=management;
	}
	
	public String getManagement() {
		return management;
	}
}
