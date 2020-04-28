package com.sapient.productcatalogue.model;

import org.springframework.stereotype.Component;

import com.sapient.productcatalogue.domain.Product;
import com.sapient.productcatalogue.model.ProductDto.ProductDtoBuilder;

@Component
public class ProductMapper {

	public ProductDto productToProductDto(Product product) {
		if (product == null)
			return null;

		ProductDtoBuilder productDto = ProductDto.builder();

		productDto.sku(product.getSku()).name(product.getName()).category(product.getCategory())
				.brand(product.getBrand()).size(product.getSize()).price(product.getPrice()).color(product.getColor());

		return productDto.build();
	}

}
