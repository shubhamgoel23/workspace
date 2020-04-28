package com.sapient.productcatalogue.model;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class ProductPagedList extends PageImpl<ProductDto> {

	public ProductPagedList(List<ProductDto> content, Pageable pageable, long total) {
		super(content, pageable, total);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
