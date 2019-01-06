package ch.hevs.businessobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //give primary key @id
@Table(name="Sport") //annotation for persistence
public class Position {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name="description")
	private int positionNumber;
	
	
	public Position() {
		super();
	}
	public Position(long id) {
		super();
		this.id = id;
	}
	public Position(long id, int positionNumber) {
		super();
		this.id = id;
		this.positionNumber = positionNumber;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getpositionNumber() {
		return positionNumber;
	}
	public void setpositionNumber(int positionNumber) {
		this.positionNumber = positionNumber;
	}
	
	@Override
	public String toString() {
		return "Sport [id=" + id + ", number=" + positionNumber +  "]";
	}
	
	

}

