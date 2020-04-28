package com.sapient.productcatalogue.web;

import java.math.BigDecimal;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.productcatalogue.model.ProductCategoryEnum;
import com.sapient.productcatalogue.model.ProductColorEnum;
import com.sapient.productcatalogue.model.ProductDto;
import com.sapient.productcatalogue.model.ProductPagedList;
import com.sapient.productcatalogue.model.ProductSizeEnum;
import com.sapient.productcatalogue.services.ProductService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

	private static final Integer DEFAULT_PAGE_NUMBER = 0;
	private static final Integer DEFAULT_PAGE_SIZE = 25;

	private final ProductService productService;

	/**
	 * this method is used to find products based on brand, price,color,size
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param brand
	 * @param color
	 * @param size
	 * @param price
	 * @return {@link ProductPagedList}
	 */
	@GetMapping(produces = { "application/json" })
	public ResponseEntity<ProductPagedList> listProducts(
			@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "brand", required = false) ProductCategoryEnum brand,
			@RequestParam(value = "color", required = false) ProductColorEnum color,
			@RequestParam(value = "size", required = false) ProductSizeEnum size,
			@RequestParam(value = "price", required = false) BigDecimal price) {

		if (pageNumber == null || pageNumber < 0) {
			pageNumber = DEFAULT_PAGE_NUMBER;
		}

		if (pageSize == null || pageSize < 1) {
			pageSize = DEFAULT_PAGE_SIZE;
		}

		ProductPagedList productList = productService.listProducts(brand, color, size, price,
				PageRequest.of(pageNumber, pageSize));

		return new ResponseEntity<>(productList, HttpStatus.OK);
	}

	/**
	 * this method is used to get product based on sku
	 * 
	 * @param sku
	 * @return {@link ProductDto}
	 */
	@GetMapping(produces = { "application/json" }, path = "sku/{sku}")
	public ResponseEntity<ProductDto> getProductBySku(
			@PathVariable("sku") String sku) {

		return new ResponseEntity<>(productService.getProductBySku(sku), HttpStatus.OK);

	}

}
