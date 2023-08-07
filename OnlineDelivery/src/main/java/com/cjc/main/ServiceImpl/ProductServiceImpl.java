package com.cjc.main.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cjc.main.Exception.ProductNotFountException;
import com.cjc.main.Model.Product;
import com.cjc.main.RepositoryI.ProductRepositoryI;
import com.cjc.main.ServiceI.ProductServiceI;

@Service
public class ProductServiceImpl implements ProductServiceI{
	
	@Autowired
	ProductRepositoryI pri;

	@Override
	public Product saveProductDetails(Product p) {
		
		return pri.save(p);
	}

	@Override
	public Iterable<Product> getAllProduct(int pageNumber) {
		
		Sort s = Sort.by("productName");
		
		Pageable pageable= PageRequest.of(pageNumber, 2,s);
		
		return pri.findAll(pageable);
	
	}

	@Override
	public Product updateProductDetails(int productId, Product pro) {
		
		Optional<Product> optionalPro = pri.findById(productId);
		
		if(optionalPro.isPresent()) {
			
		Product updateProduct = pri.save(pro);
		
		return updateProduct;
			
		}else {
			
			// throw Exception
		}
		return null;
	}

	@Override
	public void deleteProductDetails(int productId) {
		
		pri.deleteById(productId);
		
	}

	@Override
	public List<Product> findProductName(String productName) throws ProductNotFountException {
		
		List<Product> pro = pri.findAllByProductName(productName);
		
		if(pro.size()!=0) {
			
			return pro;
		}else {
			
			throw new ProductNotFountException("No Such User In DataBase With Name"+productName);
		}
		
	}

}
