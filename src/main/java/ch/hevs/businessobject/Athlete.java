package ch.hevs.businessobject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity //give primary key @id
@Table(name="Athlete") //annotation for persistence
public class Athlete {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name="lastname")
	private String lastname;
	@Column(name="firstname")
	private String firstname;
	@Column(name="country")
	private String country;
	@Column(name="year")
	private int year;
	
	// Number refers to the Positions

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "winner", cascade = CascadeType.ALL)
    private List<Number> numbers;
	
	
	
	
	@OneToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	
	@ManyToMany( mappedBy="athletes")
	private Set<Sport> sports;
	
	
	public Set<Sport> getSports() {
		return sports;
		}
	public void setProjects(Set<Sport> sports) {
		this.sports = sports;
		}
	
	
	public Athlete() {
		super();
	}
	public Athlete(long id) {
		super();
		this.id = id;
	}
	
	
	public Athlete(long id, String lastname, String firstname, String country, int year) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.country = country;
		this.year = year;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public List<Number> getNumbers(){
		return numbers;
	}
	
	public void setNumber(List<Number> numbers) {
		this.numbers = numbers;
	}
	
	@Override
	public String toString() {
		return "Athlete [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", country=" + country
				+ ", year=" + year + "]";
	}
	
	
	
	

}

