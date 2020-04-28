package com.sapient.productcatalogue.services;

import java.math.BigDecimal;

import org.springframework.data.domain.PageRequest;

import com.sapient.productcatalogue.model.ProductCategoryEnum;
import com.sapient.productcatalogue.model.ProductColorEnum;
import com.sapient.productcatalogue.model.ProductDto;
import com.sapient.productcatalogue.model.ProductPagedList;
import com.sapient.productcatalogue.model.ProductSizeEnum;

public interface ProductService {

	ProductPagedList listProducts(ProductCategoryEnum brand, ProductColorEnum color, ProductSizeEnum size,
			BigDecimal price, PageRequest of);

	ProductDto getProductBySku(String sku);

}
