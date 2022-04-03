package com.mmustafa.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="categories")
@Entity
public class Category {
	
	@Id
	@Column(name="category_id")
	private int categoryİd;
	
	@Column(name = "category_name")
	private String ctegoryName;
	
	@OneToMany(mappedBy = "categories")
	private List<Product> products;

}
