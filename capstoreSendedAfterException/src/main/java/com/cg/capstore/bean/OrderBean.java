package com.cg.capstore.bean;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="orderDetails")
public class OrderBean {

	@Id
	@Column(name="order_id")
	@GeneratedValue
	private Integer orderId;
	
	@Column(name="order_status")
	private String orderStatus;
	
	@Column(name="quantity")
	private int quantity;
	
	@ManyToMany//(targetEntity=Product.class)
	@JoinColumn(name="product_id")
	private List<ProductBean> product;
	//private Customer customer;
	@Column(name="payment_method")
	private String paymentMethod;
	
	@Column(name="date_of_order")
	private Date dateOfOrder; //sql.date
	
	@Column(name="delivery_date")
	private Date deliveryDate;  //sql.date
	
	@Column(name="min_billing_amount")
	private Integer minBillingAmount;
	
	@Column(name="Total")
	private double totalPrice;
	
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public List<ProductBean> getProduct() {
		return product;
	}
	public void setProduct(List<ProductBean> product) {
		this.product = product;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Date getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Integer getMinBillingAmount() {
		return minBillingAmount;
	}
	public void setMinBillingAmount(Integer minBillingAmount) {
		this.minBillingAmount = minBillingAmount;
	}
	
	public OrderBean(Integer orderId, String orderStatus, int quantity, List<ProductBean> product, String paymentMethod,
			Date dateOfOrder, Date deliveryDate, Integer minBillingAmount, double totalPrice) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.quantity = quantity;
		this.product = product;
		this.paymentMethod = paymentMethod;
		this.dateOfOrder = dateOfOrder;
		this.deliveryDate = deliveryDate;
		this.minBillingAmount = minBillingAmount;
		this.totalPrice = totalPrice;
	}
	public OrderBean() {
		super();
	}

	

}
