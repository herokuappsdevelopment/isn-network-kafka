/**
 * 
 */
package com.isn.network.model;

/**
 * @author tcts-india
 *
 */
public class ProductMetaData {
	
	public static final String TOPIC="product-metadata-topic";
	public static final String PRODUCT_INFO_TOPIC="product-info-topic";
	
	private String sku;
	private String productName;
	private Double price;
	
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	

}
