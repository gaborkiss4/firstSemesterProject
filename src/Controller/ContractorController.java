package Controller;

import java.util.ArrayList;
import Model.Contractor;
import Model.ContractorContainer;


public class ContractorController {

	private static ContractorController instance = new ContractorController();
	private ContractorContainer contractorContainer;
	
	private ContractorController() {
		contractorContainer = ContractorContainer.getInstance();
	}
	
	public static ContractorController getInstance() {
		return instance;
	}
	
	public ArrayList<Contractor> findByName(String firm) {
		
		return ContractorContainer.getInstance().findByName(firm); 
	}
	public ArrayList<Contractor> getAllContractors() {
		
		return ContractorContainer.getInstance().getAllContractors(); 
	}
	
	public String[][] getTable(){
		ArrayList<Contractor> contractors = ContractorContainer.getInstance().getAllContractors();
		int n = contractors.size();
		String[][] table = new String[n][5];
		for(int i=0; i<n; i++) {
			table[i][0] = contractors.get(i).getFirm();
			table[i][1] = contractors.get(i).getStartDate();
			table[i][2] = contractors.get(i).getDirectorName();
			table[i][3] = Integer.toString(contractors.get(i).getDirectorNumber());
			table[i][4] = Integer.toString(contractors.get(i).getServiceNumber());
		}
		return table;
	}
	
	public Contractor findByServiceNumber(int serviceNumber) { 
	
		return ContractorContainer.getInstance().findByServiceNumber(serviceNumber); 
	}
	
	public boolean createContractor(String firm,String startDate,String directorName,int directorNumber,int serviceNumber) {
		
		if(ContractorContainer.getInstance().findByServiceNumber(serviceNumber) == null)
			return ContractorContainer.getInstance().addContractor(new Contractor(firm, startDate, directorName, directorNumber, serviceNumber));
		return false;
	}
	
	public boolean updateContractor(int oldServiceNumber, String firm,String startDate,String directorName,int directorNumber,int serviceNumber) {
	
		int contractorIndex = contractorContainer.getContractorIndex(oldServiceNumber);
		
		String newFirm = firm == "" ? contractorContainer.getAllContractors().get(contractorIndex).getFirm() : firm;
		String newStartDate = startDate == "" ? contractorContainer.getAllContractors().get(contractorIndex).getStartDate() : startDate;
		String newDirectorName = directorName == "" ? contractorContainer.getAllContractors().get(contractorIndex).getDirectorName() : directorName;  
		int newDirectorNumber = directorNumber == 0 ? contractorContainer.getAllContractors().get(contractorIndex).getDirectorNumber() : directorNumber;
		int newServiceNumber = serviceNumber == 0 ? contractorContainer.getAllContractors().get(contractorIndex).getServiceNumber() : serviceNumber;                      
		
		
		
	
		if(contractorContainer.findByServiceNumber(newServiceNumber)!= null && oldServiceNumber!= newServiceNumber) { 
			return false;
		}
		
		
		return ContractorContainer.getInstance().updateContractor(contractorIndex, newFirm,newStartDate, newDirectorName, newDirectorNumber,newServiceNumber);
	}
	
	public boolean deleteContractor(int serviceNumber) {
		return ContractorContainer.getInstance().removeContractor(serviceNumber);
	}
	
	
	
	
	
	
}


