package ch.hevs.businessobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity //give primary key @id
@Table(name="Category") //annotation for persistence
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	
	@OneToOne( mappedBy = "category")
	private Athlete athlete;
	
	
	
	
	public Category() {
		super();
	}
	
	
	public Category(long id) {
		super();
		this.id = id;
	}
	
	public Category(long id, String name, String description) {
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

