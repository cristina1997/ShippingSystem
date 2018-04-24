package com.ships.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Ship {
	@Id
	@GeneratedValue
	private int sid;
	@NotNull
    @Size(min=1,max=250, message="Size must be between 1 and 250")
	private String name;
	@Min(value = 0, message="Size must be greater than or equal to 0")
	private int passengers;
	@NotNull(message="Size must be between 1 and 250")
	private BigDecimal cost;
	@Min(value = 1, message="Size must be greater than or equal to 1")
	private double metres;
	
	@ManyToOne
	@JoinColumn(name="scid")
	private ShippingCompany shippingCompany;
		
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPassengers() {
		return passengers;
	}
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public double getMetres() {
		return metres;
	}
	public void setMetres(double metres) {
		this.metres = metres;
	}
	public ShippingCompany getShippingCompany() {
		return shippingCompany;
	}
	public void setShippingCompany(ShippingCompany shippingCompany) {
		this.shippingCompany = shippingCompany;
	}
	@Override
	public String toString() {
		return name + ", " + metres + ", "+ cost; 
	}	
	
}
