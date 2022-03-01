package com.jonathandimawea.savetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "expenses")
public class Expense {

	// 1. attributes
	// 2. constructor
	// 3. getter & setter

	// REMARKS:
	// 1. DO NOT USE SQL reserved words for attributes -- ex. DESC/ASC
	// 2. DO NOT USE UNDERSCORE for attributes

	// -------------------- Attributes -------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Must input name")
	@Size(min = 2, max = 200, message = "too short")
	private String name;

	@NotNull(message = "Must input vendor")
	@Size(min = 2, max = 200, message = "too short")
	private String vendor;
	
	@NotNull
	@Min(0)
	private Double amount;

	private String description;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	// ------------------------ Constructor -------------------------
	// Always have an empty constructor
	public Expense() {}

	public Expense(String name, String vendor, Double amount, String description) {
			this.name = name;
			this.vendor = vendor;
			this.amount = amount;
			this.description = description;
		}

	// ------------------- Getter & Setter -------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	

	// other getters and setters removed for brevity
	@PrePersist // when it gets created, it runs this function
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate // change the updated at to the current date of the computer
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}
