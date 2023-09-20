package com.assignment.project.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="ProductTable")
public class Product {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	private @Nonnull String name;
	
	
	private @Nonnull String imageurl;
	
	
	private@Nonnull String discrption;
	
	private @Nonnull double price;
	
	

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "Category_Id")
	Category category;
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getDiscrption() {
		return discrption;
	}

	public void setDiscrption(String discrption) {
		this.discrption = discrption;
	}

	public Integer getId() {
		return Id;
	}
	

	public void setId(Integer id) {
		Id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

}
