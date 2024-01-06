package entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entites.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> orderList = new ArrayList<>();
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderList() {
		return orderList;
	}
	
	public void addItem(OrderItem order) {
		orderList.add(order);
	}
	
	public void removeItem(OrderItem order) {
		orderList.remove(order);
	}
	
	public double total() {
		double sub = 0;
		for(OrderItem order : orderList) {
			sub = order.subTotal();
		}
		return sub;
	}
}
