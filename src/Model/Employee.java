package Model;

public class Employee {
	private String name;
	private int id;
	private int salary;
	private Employee boss;
	private String location;
	private boolean management;
	
	private int turnover;
	
	public Employee(String name, int id, int salary, Employee boss, String location, boolean management) {
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.boss = boss;
		this.location = location;
		this.management = management;
		this.turnover = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public Employee getBoss() {
		return boss;
	}
	
	public String getLocation() {
		return location;
	}
	
	public boolean isManagement() {
		return management;
	}
}
