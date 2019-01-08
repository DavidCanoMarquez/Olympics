package ch.hevs.bankservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ch.hevs.businessobject.Account;
import ch.hevs.businessobject.Client;
import ch.hevs.businessobject.Sport;

@Stateless
public class OlympicBean implements Olympic {

	@PersistenceContext(name = "OlympicPU")
	private EntityManager em;

	public Account getAccount(String accountDescription, String lastnameOwner) {
		Query query = em.createQuery("FROM Account a WHERE a.description=:description AND a.owner.lastname=:lastname");
		query.setParameter("description", accountDescription);
		query.setParameter("lastname", lastnameOwner);
		
		return (Account) query.getSingleResult();
	}
	/*@Override
	public Sport getSport(String sportname, String sportDescription) {
		Query query = em.createQuery("FROM Sport s WHERE s.name=:name AND s.description.lastname=:lastname");
		query.setParameter("description", accountDescription);
		query.setParameter("lastname", lastnameOwner);
		
		return (Account) query.getSingleResult();
	}*/
	
	
	
	
	public List<Account> getAccountListFromClientLastname(String lastname) {
		return (List<Account>) em.createQuery("SELECT c.accounts FROM Client c where c.lastname=:lastname").setParameter("lastname", lastname).getResultList();
	}
	@Override
	public List<Sport> getSportListFromAthleteLastname(String lastname) {
		return (List<Sport>) em.createQuery("SELECT a.sports FROM Athlet a where a.lastname=:lastname").setParameter("lastname", lastname).getResultList();

	}
	
	

	public void transfer(Account srcAccount, Account destAccount, int amount) {
		
		em.persist(srcAccount);
		em.persist(destAccount);
		srcAccount.debit(amount);
		destAccount.credit(amount);
	}

	public List<Client> getClients() {
		return em.createQuery("FROM Client").getResultList();
	}
	@Override
	public List<Sport> getSports() {
		return em.createQuery("FROM Sport").getResultList();
	}
	
	
	
	public Client getClient(long clientid) {
		return (Client) em.createQuery("FROM Client c where c.id=:id").setParameter("id", clientid).getSingleResult();
	}

	@Override
	public Sport getSport(long id) {
		return (Sport) em.createQuery("FROM Sport s where s.id=:id").setParameter("id", id).getSingleResult();
	}


}
