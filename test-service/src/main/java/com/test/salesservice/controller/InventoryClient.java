package com.test.salesservice.controller;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.configuration.FeignConfiguration;

import com.example.model.Product;
import com.example.model.StockProducts;

//"http://localhost:8000"

@FeignClient(value = "inventory-service",url = "http://localhost:8000",
configuration = FeignConfiguration.class)
public interface InventoryClient {

	@GetMapping("/ims-api/product/{pid}")
	public Product getProduct(@PathVariable("pid") String pid);

    @GetMapping ("/ims-api/product/vendor/{vendor}")
    public List<Product> getProductsByVendor(@PathVariable("vendor") String vendor);
    
    
    /////////////////////////////////////////////////////////////////////////////////////
    
    

	 @RequestMapping(value = "/product-api/stock/{sid}/product/",method = RequestMethod.GET,produces = "application/json")
		public Iterable<StockProducts> getNewAllProducts(@PathVariable("sid") String sid);
    
    
    
    
}
