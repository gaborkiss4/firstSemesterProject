package Model;

import java.util.ArrayList;
import java.util.Iterator;

public class ContractorContainer {

	private ArrayList<Contractor> contractors;
	private static ContractorContainer instance;
	
	private ContractorContainer() {
		
		contractors= new ArrayList<>();
		
	}
	public static ContractorContainer getInstance() {
		
		if (instance == null) {
			
			instance = new ContractorContainer();
		}
		return instance;
	}
	public boolean addContractor(Contractor contractor) {
		
		return contractors.add(contractor);
	}
	public boolean updateCustomer(int conindex,String firm,String startDate,String directorName,int directorNumber,int serviceNumber) 
	{
		contractors.get(conindex).setFirm(firm);
		contractors.get(conindex).setStartDate(startDate);
		contractors.get(conindex).Director(directorNumber,directorName);
		contractors.get(conindex).setServiceNumber(serviceNumber);
		return true;
	}
	public boolean removeContractor(int serviceNumber) {
		Iterator<Contractor> contractorIterator = contractors.iterator();  //--------------------------------------------------
		
		while(contractorIterator.hasNext()) {
			if(contractorIterator.next().getServiceNumber() == serviceNumber) {
				contractorIterator.remove();
				return true;
			}
		}
		return false;
	}
	public ArrayList<Contractor> findByName(String firm) {      
		ArrayList<Contractor> results = new ArrayList<>();
		for (Contractor contractor : contractors) {                 //--------------------------------------------------
			if (contractor.getFirm().toLowerCase().contains(firm.toLowerCase())) {
				results.add(contractor);
			}
		}
		return results;
	}
	
	public Contractor findByServiceNumber(int serviceNumber) {       //--------------------------------------------------
		for (Contractor contractor : contractors) {
			if (contractor.getServiceNumber() == serviceNumber) {
				return contractor;
			}
		}
		return null;
	}
	
	public int getContractorIndex(int serviceNumber) { //--------------------------------------------------
		int contractorIndex = -1;
		for(int i = 0; i < contractors.size(); i++) {
			if(contractors.get(i).getServiceNumber() == serviceNumber)  //gets an index of a person
				contractorIndex = i;
		}
		return contractorIndex;
	}
	
	public ArrayList<Contractor> getAllPeople(){
		return contractors;
	}
	
	
	
	
	
	
	
	
	
	
	
}
