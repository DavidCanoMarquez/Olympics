package ch.hevs.bankservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ch.hevs.businessobject.Sport;

@Stateless
public class OlympicBean implements Olympic {
	
	@PersistenceContext(name = "OlympicPU")
	private EntityManager em;

	
	

	@Override
	public List<Sport> getSports() {
		return em.createQuery("FROM Sport").getResultList();
	}

	@Override
	public List<Sport> getSportListFromName(String name) {
		return (List<Sport>) em.createQuery("SELECT s.name FROM Sport s where s.name=:name").setParameter("name", name).getResultList();
	}

	@Override
	public Sport getSport(long id) {
		return (Sport) em.createQuery("FROM Sport s where s.id=:id").setParameter("id", id).getSingleResult();
	}
}
