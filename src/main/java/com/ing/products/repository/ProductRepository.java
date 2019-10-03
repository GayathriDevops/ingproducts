/**
 * 
 */
package com.ing.products.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ing.products.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value = "SELECT t FROM Product t WHERE t.category.categoryId =:categoryId")
	Optional<List<Product>> findAllByProductCategoryId(@Param("categoryId")int categoryId);

	Product findByProductId(int productId);

	
}