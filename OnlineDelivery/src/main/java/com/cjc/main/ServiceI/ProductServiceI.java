package com.cjc.main.ServiceI;

import java.util.List;

import com.cjc.main.Exception.ProductNotFountException;
import com.cjc.main.Model.Product;

public interface ProductServiceI {

	Product saveProductDetails(Product p);

	Iterable<Product> getAllProduct(int pageNumber);

	Product updateProductDetails(int productId, Product pro);

	void deleteProductDetails(int productId);

	List<Product> findProductName(String productName)throws ProductNotFountException;

}
