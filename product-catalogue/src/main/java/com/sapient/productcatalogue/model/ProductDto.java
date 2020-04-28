package com.sapient.productcatalogue.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

	private String sku;

	private String name;

	private ProductCategoryEnum category;

	private String brand;

	private ProductColorEnum color;

	private ProductSizeEnum size;

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private BigDecimal price;

}
