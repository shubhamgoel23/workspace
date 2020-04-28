package com.sapient.productcatalogue.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sapient.productcatalogue.domain.Product;
import com.sapient.productcatalogue.model.ProductCategoryEnum;
import com.sapient.productcatalogue.model.ProductColorEnum;
import com.sapient.productcatalogue.model.ProductSizeEnum;

public interface ProductRepository extends JpaRepository<Product, String>{
	
	Page<Product> findAllByBrand(ProductCategoryEnum brand, Pageable pageRequest);

	Page<Product> findAllByColor(ProductColorEnum color, Pageable pageRequest);

	Page<Product> findAllBySize(ProductSizeEnum size, Pageable pageRequest);
	
	Page<Product> findAllByPrice(BigDecimal price, Pageable pageRequest);
	
	@Query("select p from Product p where p.sku=:sku")
	Product findAllBySku(@Param("sku") String sku);

}
