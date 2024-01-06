package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entites.Client;
import entites.Order;
import entites.OrderItem;
import entites.Product;
import entites.enums.OrderStatus;

public class Program {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("Enter client data: ");
		System.out.println("Name: ");
		String clientName = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		System.out.println("Birth date: ");
		Date birthDate = sdf.parse(sc.next());
	
		
		System.out.println("Enter order data: ");
		System.out.println("Status: ");
		String status = sc.next();
		
		Order order = new Order (new Date(), OrderStatus.valueOf(status),
				new Client(clientName, email, birthDate));
		
		System.out.println("How Many items to this order: ");
		int quantity = sc.nextInt();
		
		for(int i = 1; i <= quantity; i++) {
			System.out.println("Enter # " + i + "item data:");
			sc.nextLine();
			System.out.println("Product name: ");
			String productName = sc.nextLine();
			System.out.println("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.println("Quantity: ");
			int productQauntity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(productQauntity, new Product(productName, productPrice));
			order.addItem(orderItem);
		}
		
		System.out.println("ORDER SUMMARY: ");
		System.out.println("Order moment: " + order.getMoment());
		System.out.println("Order status: " + order.getStatus());
		System.out.println("Client " + order.getClient().getName() + " (" + order.getClient().getBirthDate() + ") - " + order.getClient().getEmail());
		
		System.out.println("Order items: ");
		System.out.println(order.getOrderList());
	}
}
