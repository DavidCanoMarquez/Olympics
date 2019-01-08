package ch.hevs.bankservice;

import java.util.List;

import javax.ejb.Local;


import ch.hevs.businessobject.*;

@Local
public interface Olympic {

	Account getAccount(String accountDescription, String lastnameOwner);
	//Sport getSport(String sportname, String sportDescription);
	
	public List<Account> getAccountListFromClientLastname(String lastname);
	public List<Sport> getSportListFromAthleteLastname(String lastname);

	void transfer(Account compteSrc, Account compteDest, int montant) throws Exception;

	List<Client> getClients();
	List<Sport> getSports();

	Client getClient(long clientid);
	Sport getSport(long id);
}
