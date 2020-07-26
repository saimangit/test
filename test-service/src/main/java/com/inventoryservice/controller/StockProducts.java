package com.inventoryservice.controller;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="product")
public class StockProducts implements Serializable{
      
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="pid",nullable = false)	
	  private Long pid;
	  
	  @Column(name="product_name",nullable = false)
	  private String productName;
	  @Column(name="list_price",nullable = false) 
	  private int listPrice;
	  @Column(name="discount",nullable = false)   
	  private int discount;
	  
	  @Column(name="created_user",nullable = false) 
	  private String createdUser;
	  
	  @Column(name="created_date",nullable = false)   
	  private String createdDate;
	  
	  @ManyToOne(fetch = FetchType.EAGER)
	  @JsonIgnore
	  @JoinColumn(name = "supplier_id",referencedColumnName = "supplier_id")
	  private Stock stock;
	  
	  
	  
	public StockProducts() {
		super();
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
		stock.getStockProducts().add(this);
	}

	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getListPrice() {
		return listPrice;
	}
	public void setListPrice(int listPrice) {
		this.listPrice = listPrice;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	  
	  
	  
	
}
