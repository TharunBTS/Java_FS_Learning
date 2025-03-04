/*
 * find out the highest orders in a year
 * find out category wise orders count
 * print max price from orders
 * month wise avg spending details
 * find out min order price from total orders
 * first and last product purchased
 * 
 * */


//price, ordre_name,order_yaer,order_month,qty,id,city

import java.util.*;
import java.util.stream.Collectors;

class Order
{
	private int id;
	private String name;
	private long price;
	private int year;
	private int month;
	private int qty;
	private String city;
	private String category;
	
	
	public Order(int id, String name, long price, int year, int month, int qty, String city, String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.year = year;
		this.month = month;
		this.qty = qty;
		this.city = city;
		this.category = category;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", price=" + price + ", year=" + year + ", month=" + month
				+ ", qty=" + qty + ", city=" + city + ", category=" + category + "]";
	}
	
	
}

public class General {
	
	// highest orders in a year
	public static void highestOrder(List<Order> li)
	{
		Optional<Order> ref = li.stream().max(Comparator.comparing(Order :: getQty));
		Order rl = ref.get();
		System.out.println(rl);
	}
	
	// orders count
	public static void ordersCount(List<Order> li)
	{
		Map<String, List<Order>> ds = li.stream().collect(Collectors.groupingBy(Order :: getCategory));
		for(String s : ds.keySet())
		{
			System.out.print(s+" ----> ");
			int sum = 0 ;
			for(Order f: ds.get(s))
			{
				sum += f.getQty();
			}
			System.out.print(sum);
			System.out.println();
		}

	}
	
	// max price from orders
	public static void maxPrice(List<Order> li)
	{
		Optional<Order> oo= li.stream().max(Comparator.comparing(Order :: getPrice));
		Order m = oo.get();
		System.out.println(m.getName()+" "+m.getPrice());
	}
	
	// month wise order
	public static void monthWiseOrder(List<Order> li)
	{
		Map<Integer, List<Order>> mo = li.stream().collect(Collectors.groupingBy(Order :: getMonth));
		for(Integer s : mo.keySet())
		{
			System.out.print(s+" ----> ");
			int sum = 0 ;
			for(Order f: mo.get(s))
			{
				sum += f.getQty();
			}
			System.out.print(sum);
			System.out.println();
		}
		
	}
	
	public static void main(String args[]) {
	List<Order> ol = new ArrayList<>();
	ol.add(new Order(1, "Product1", 1000L, 2025, 3, 10, "New York", "Electronics"));
    ol.add(new Order(2, "Product2", 1500L, 2025, 4, 5, "Los Angeles", "Home Appliances"));
    ol.add(new Order(3, "Product3", 2000L, 2025, 5, 20, "Chicago", "Furniture"));
    ol.add(new Order(4, "Product4", 2500L, 2025, 6, 15, "Houston", "Toys"));
    ol.add(new Order(5, "Product5", 3000L, 2025, 7, 25, "Phoenix", "Books"));
    ol.add(new Order(1, "Product1", 1000L, 2025, 3, 10, "New York", "Electronics")); // Duplicate
    ol.add(new Order(6, "Product6", 3500L, 2025, 8, 30, "Philadelphia", "Clothing"));
    ol.add(new Order(7, "Product7", 4000L, 2025, 9, 10, "San Antonio", "Sports"));
    ol.add(new Order(2, "Product2", 1500L, 2025, 4, 5, "Los Angeles", "Home Appliances")); // Duplicate
    ol.add(new Order(8, "Product8", 4500L, 2025, 10, 5, "San Diego", "Electronics"));
    
    System.out.println(" Question 1");
    General.highestOrder(ol);
    System.out.println("--------------------------------");
    
    System.out.println(" Question 2");
    General.ordersCount(ol);
    System.out.println("--------------------------------");
    
    System.out.println(" Question 3");
    General.maxPrice(ol);
    System.out.println("--------------------------------");
    
    System.out.println(" Question 4");
    General.monthWiseOrder(ol);
    System.out.println("--------------------------------");
    
	}
}


/*
 * find out the highest orders in a year
 * find out category wise orders count
 * print max price from orders
 * month wise avg spending details
 * find out min order price from total orders
 * first and last product purchased
 * 
 * */

