package com.ing.products.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.products.constants.ProductConstants;
import com.ing.products.dto.ProductDetailDto;
import com.ing.products.entity.Product;
import com.ing.products.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
	
	ProductConstants constants;
		
	@Autowired
	ProductRepository productrepository;
	
	
	public Optional<List<Product>> showproducts(int categoryId) {
		
		return productrepository.findAllByProductCategoryId(categoryId);
	}
	
	@Override
	public ProductDetailDto viewProductDetails(int productId) {
		Product product = productrepository.findByProductId(productId);
		
        ProductDetailDto productDetailDto = new ProductDetailDto();
       
        productDetailDto.setStatusCode(constants.SUCCESS_STATUS_CODE);
        productDetailDto.setMessage(constants.SUCCESS_MESSAGE);
        productDetailDto.setProduct(product);
        return productDetailDto ;
        
	}

}
