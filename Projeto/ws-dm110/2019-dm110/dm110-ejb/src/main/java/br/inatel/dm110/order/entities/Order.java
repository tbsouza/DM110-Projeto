package br.inatel.dm110.order.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER") // Table name in database
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int orderCode;
	private int productCode;
	private String cpf;
	private int amount;
	private Date saleDate;
	private float value;

	public Order() {
	}

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int producCode) {
		this.productCode = producCode;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
