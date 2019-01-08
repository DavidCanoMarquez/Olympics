package ch.hevs.bankservice;

import java.util.List;

import javax.ejb.Local;


import ch.hevs.businessobject.*;
import ch.hevs.businessobject.Sport;

@Local
public interface Olympic {

	List<Sport> getSports();

	//Account getAccount(String accountDescription, String lastnameOwner);
	
	public List<Sport> getSportListFromName(String name);

	//void transfer(Account compteSrc, Account compteDest, int montant) throws Exception;

	//List<Client> getClients();

	Sport getSport(long id);

	
}
