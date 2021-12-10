package Model;

public class Contractor {

	private String firm;
	private String startDate;
	private String directorName;
	private int directorNumber;
	private int serviceNumber;
	
	
	
	
	public Contractor(String firm,String startDate,String directorName,int directorNumber,int serviceNumber) {
		
		this.firm= firm;
		this.startDate= startDate;
		this.directorName = directorName;
		this.directorNumber= directorNumber;
		this.serviceNumber = serviceNumber;
		
		
	}
public void setDirectorName(String directorName) {
		
		this.directorName = directorName;
		
	}
	public String getDirectorName() {
		
		return directorName;
		
	}
public void setDirectorNumber(int directorNumber) {
		
		this.directorNumber = directorNumber;
		
	}
	public int getDirectorNumber() {
		
		return directorNumber;
		
	}
	
	public void Director(int directorNumber,String directorName) {
		this.directorNumber= directorNumber;
		this.directorName =directorName;
	}
	
	public String Director() {
		return (directorName + ":  "+ directorNumber);
	}
	
	public void setFirm(String firm) {
		this.firm = firm;
	}
	
	public String getFirm() {
		return firm;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setServiceNumber(int serviceNumber) {
		this.serviceNumber = serviceNumber;
	}
	
	public int getServiceNumber() {
		return serviceNumber;
	}
	
}
