package br.inatel.dm110.api;

import java.io.Serializable;
import java.util.Date;

public class OrderTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int orderCode;
	private int producCode;
	private String cpf;
	private int amount;
	private Date saleDate;
	private float value;

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public int getProducCode() {
		return producCode;
	}

	public void setProducCode(int producCode) {
		this.producCode = producCode;
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

}
