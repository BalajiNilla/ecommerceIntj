package com.assignment.project.models;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name="wishlist")
public class Wishlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	
	private Date CreatedDate;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	
	@ManyToOne(targetEntity = User.class,fetch = FetchType.EAGER)
	@JoinColumn(nullable=false,name="UserId")
	private User user;
	

	public Wishlist(Integer Id, User user, Date CreatedDate, Product product) {
		super();
		this.Id = Id;
		this.user = user;
		this.CreatedDate = CreatedDate;
		this.product = product;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Wishlist() {
	}

	public Wishlist(User user, Product product) {
		super();
		this.user = user;
		this.product = product;
		this.CreatedDate=new Date();
	}

}
