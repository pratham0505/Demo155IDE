package com.cjc.main.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.Exception.ProductNotFountException;
import com.cjc.main.Model.BaseResponce;
import com.cjc.main.Model.Product;
import com.cjc.main.ServiceI.ProductServiceI;

@CrossOrigin("*")
@RestController
@RequestMapping("/product")
public class HomeController {
	
	@Autowired
	ProductServiceI psi;
	
	@RequestMapping("/createProDetails")
	public ResponseEntity<BaseResponce<Product>> createProDetails(@RequestBody Product p){
		
		Product pro = psi.saveProductDetails(p);
		
		return new ResponseEntity<BaseResponce<Product>>(new BaseResponce<Product>(201, "Create Product", new Date(), pro), HttpStatus.CREATED);
	}
	
	@GetMapping("/products/{pageNumber}")
	public Iterable<Product> getAllProDetails(@PathVariable int pageNumber){
		
		Iterable<Product> user = psi.getAllProduct(pageNumber);
		
		return user;
	}
	
	@PutMapping("/products/{productId}")
	public Product updateProData(@PathVariable int productId ,@RequestBody Product pro) {
		
		Product p = psi.updateProductDetails(productId,pro);
		
		return p;
	}
	
	@DeleteMapping("products/{productId}")
	public String removeProduct(@PathVariable int productId) {
		
		psi.deleteProductDetails(productId);
		
		return "Delete Data Successfully";
	}
	
	@GetMapping("products/{productName}")
	public ResponseEntity<BaseResponce<List<Product>>> findProduct(@PathVariable String productName)throws ProductNotFountException{
		
		List<Product> searchedProduct;
		
		searchedProduct = psi.findProductName(productName);
		
		return new ResponseEntity<BaseResponce<List<Product>>>(new BaseResponce<List<Product>>(200, "Serach Result",new Date(),searchedProduct),HttpStatus.OK);
	}
	
	@GetMapping("/getmsg")
	public String getmsg()
	{
		return "new msg";
	}
	
	@RequestMapping("/pushmsg")
	public String pusgmsg() {
		return "change msg";
	}
}
