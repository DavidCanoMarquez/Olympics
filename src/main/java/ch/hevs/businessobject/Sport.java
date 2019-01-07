package ch.hevs.businessobject;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity //give primary key @id
@Table(name="Sport") //annotation for persistence
public class Sport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	
	
	
	
	@ManyToMany
	private Set<Athlete> athletes;
	
	@ManyToMany		
	private Set<Number> numbers;
	
	
	public Set<Number> getNumbers(){
		return numbers;
	}
	
	public void setNumbers(Set<Number> numbers) {
		this.numbers = numbers;
	}
	
	
	
	public Set<Athlete> getAthletes(){
		return this.athletes;
	}
	
	
	public void setAthletes(Set<Athlete> athletes) {
		this.athletes = athletes;
	}
	
	
	public Sport() {
		super();
	}
	public Sport(long id) {
		super();
		this.id = id;
	}
	public Sport(long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Sport [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	

}

