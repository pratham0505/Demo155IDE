package com.cjc.main.RepositoryI;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjc.main.Model.Product;

public interface ProductRepositoryI extends JpaRepository<Product, Integer>{

	public List<Product> findAllByProductName(String productName);

}
