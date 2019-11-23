package br.inatel.dm110.order.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUDIT") // Table name in database
public class Audit implements Serializable {

	@Id
	private int id; // auto increment
	private int registerCode; // Order code
	private String operation; // Create, update, list
	private Date dateTime;

	public Audit() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRegisterCode() {
		return registerCode;
	}

	public void setRegisterCode(int registerCode) {
		this.registerCode = registerCode;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
}
