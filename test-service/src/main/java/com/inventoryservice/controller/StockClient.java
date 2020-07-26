package com.inventoryservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import feign.hystrix.FallbackFactory;

//url = "http://localhost:8010"

@FeignClient(value = "stock-service",url = "http://localhost:8010"
,configuration = FeignConfiguration.class,
fallback =  StockClientFallBack.class )
public interface StockClient {

	@GetMapping("/stock-api/stock")
    public List<RawStock> getAllStock();
	
	 @RequestMapping(value = "/stock-product-api/stock",method = RequestMethod.GET,produces = "application/json")
	  public List<Stock> getNewAllStock(); 
		
}

 @Component
 class StockClientFallBack implements StockClient {

	@Override
	public List<RawStock> getAllStock() {
		
		return new ArrayList<>();
	}

	@Override
	public List<Stock> getNewAllStock() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

}