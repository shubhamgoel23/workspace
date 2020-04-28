package com.sapient.productcatalogue.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.sapient.productcatalogue.model.ProductCategoryEnum;
import com.sapient.productcatalogue.model.ProductColorEnum;
import com.sapient.productcatalogue.model.ProductSizeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product {

	@Id
	@Column(unique = true, updatable = false, nullable = false)
	private String sku;

	private String name;

	@Enumerated(EnumType.STRING)
	private ProductCategoryEnum category;

	private String brand;

	@Enumerated(EnumType.STRING)
	private ProductColorEnum color;

	@Enumerated(EnumType.STRING)
	private ProductSizeEnum size;

	private BigDecimal price;

}
