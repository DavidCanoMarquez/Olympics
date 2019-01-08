package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.bankservice.Olympic;
import ch.hevs.businessobject.*;



/**
 * RegistryBean.java
 * 
 */

public class RegistryBean {
	private List<Sport> sports;
    private List<String> sportNames;
    private List<String> sportDescriptions;
    //private List<String> destinationAccountDescriptions;
    private String sportDescription;
    //private String destinationAccountDescription;
    private String sportName;
    //private String destinationClientName;
    private String registryResult;
   //private int transactionAmount;
    private Olympic olympic;
    
    @PostConstruct
    public void initialize() throws NamingException {
    	
    	// use JNDI to inject reference to bank EJB
    	InitialContext ctx = new InitialContext();
		olympic = (Olympic) ctx.lookup("java:global/Olympics-WEB-EJB-PC-EPC-E-0.0.1-SNAPSHOT/OlympicBean!ch.hevs.bankservice.Olympic");    	
			
    	// get clients
		List<Sport> sportList = olympic.getSports();
		this.sportNames = new ArrayList<String>();
		for (Sport sport : sportList) {
			this.sportNames.add(sport.getName());
		}
		
		// initialize account descriptions
		this.sportDescriptions = new ArrayList<String>();
		//this.destinationAccountDescriptions = new ArrayList<String>();
		//List<Sport> sports = olympic.getSportFromName(sportList.get(0).getName());
		this.sportDescriptions.add(sports.get(0).getDescription());
		//this.destinationAccountDescriptions.add(accounts.get(0).getDescription());
    }
    
    // transactionAmount
   /// public int getTransactionAmount () {
   // 	return transactionAmount;
   // }
   // public void setTransactionAmount (final int transactionAmount) {
   // 	this.transactionAmount=transactionAmount;
   // }
    
    // sourceClientName
    public String sportName () {
    	return sportName;
    }
    public void setSportName (final String sportName) {
    	this.sportName=sportName;
    }
    
    // sourceAccountDescriptions
    public List<String> getSportDescriptions () {
    	return sportDescriptions;
    }
    
    // destinationAccountDescriptions
   // public List<String> getDestinationAccountDescriptions () {
   // 	return destinationAccountDescriptions;
   // }
    
    // destinationClientName
    public String getSportName () {
    	return sportName;
    }
        
    // registryResult
    public String getRegistryResult () {
    	return registryResult;
    }
	public void setRegistryResult(String transactionResult) {
		this.registryResult = registryResult;
	}
    
	// sportDescription
    public String getsportDescription() {
		return sportDescription;
	}
	public void setsportDescription(String sportDescription) {
		this.sportDescription = sportDescription;
	}

	// destinationAccountDescription
	//public String getDestinationAccountDescription() {
	//	return destinationAccountDescription;
	//}
	//public void setDestinationAccountDescription(
	//		String destinationAccountDescription) {
	//	this.destinationAccountDescription = destinationAccountDescription;
	//}

	public void updateSports(ValueChangeEvent event) {
    	this.sportName = (String)event.getNewValue();
    	
	   // List<Sport> sports = olympic.getSportListFromName(this.sportName);
	    this.sportDescriptions = new ArrayList<String>();
		for (Sport sport : sports) {
			this.sportDescriptions.add(sport.getDescription());
		}
    }
	

    public List<Sport> getSports() {
		return sports;
    }
    
    public List<String> getSportNames() {
    	return sportNames;
    }
    
    
    public String performRegistry() {
    	
    	try {
			if (sportName.equals(sportName) && sportDescription.equals(sportDescription)) {
				
				this.registryResult="Error: sports are the identical!";
			} 
			else {
				
				//Sport sport = olympic.getSport(sportDescription, sportName);
				//Account compteDest = bank.getAccount(destinationAccountDescription, destinationClientName);
	
				// Register
				//olympic.registry(sport, sportName);
				this.registryResult="Success!";
			}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}

		return "showTransferResult"; //  the String value returned represents the outcome used by the navigation handler to determine what page to display next.
	} 
}