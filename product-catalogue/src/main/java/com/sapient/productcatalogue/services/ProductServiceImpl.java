package com.sapient.productcatalogue.services;

import java.math.BigDecimal;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sapient.productcatalogue.domain.Product;
import com.sapient.productcatalogue.model.ProductCategoryEnum;
import com.sapient.productcatalogue.model.ProductColorEnum;
import com.sapient.productcatalogue.model.ProductDto;
import com.sapient.productcatalogue.model.ProductMapper;
import com.sapient.productcatalogue.model.ProductPagedList;
import com.sapient.productcatalogue.model.ProductSizeEnum;
import com.sapient.productcatalogue.repositories.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	private final ProductMapper productMapper;

	@Override
	public ProductPagedList listProducts(ProductCategoryEnum brand, ProductColorEnum color, ProductSizeEnum size,
			BigDecimal price, PageRequest pageRequest) {

		ProductPagedList productPagedList;
		Page<Product> productPage;

		if (!StringUtils.isEmpty(brand)) {
			productPage = productRepository.findAllByBrand(brand, pageRequest);
		} else if (!StringUtils.isEmpty(color)) {
			productPage = productRepository.findAllByColor(color, pageRequest);
		} else if (!StringUtils.isEmpty(size)) {
			productPage = productRepository.findAllBySize(size, pageRequest);
		} else if (!StringUtils.isEmpty(price)) {
			productPage = productRepository.findAllByPrice(price, pageRequest);
		} else {
			productPage = productRepository.findAll(pageRequest);
		}

		productPagedList = new ProductPagedList(
				productPage.getContent().stream().map(productMapper::productToProductDto).collect(Collectors.toList()),
				PageRequest.of(productPage.getPageable().getPageNumber(), productPage.getPageable().getPageSize()),
				productPage.getTotalElements());

		return productPagedList;
	}

	@Override
	public ProductDto getProductBySku(String sku) {

		Product product = productRepository.findById(sku)
				.orElse(Product.builder().sku(sku).name("ProductNotFound").build());
		return productMapper.productToProductDto(product);
	}

}
