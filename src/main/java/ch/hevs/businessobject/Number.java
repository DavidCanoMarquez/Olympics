package ch.hevs.businessobject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity //give primary key @id
	@Table(name="Number") //annotation for persistence
	public class Number {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	
	@Column(name="number")
	private int number;
	@Column(name="description")
	private String description;
	
	public Number() {
		super();
	}
	public Number(long id) {
		super();
		this.id = id;
	}
	public Number(long id, int number, String description) {
		super();
		this.id = id;
		this.number = number;
		this.description = description;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Sport [id=" + id + ", number=" + number + ", description=" + description + "]";
	}
	
	

}

