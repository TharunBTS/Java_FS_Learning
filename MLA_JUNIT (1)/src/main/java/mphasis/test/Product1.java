package mphasis.test;

import java.util.Objects;

public class Product1 {
	
	private String name;
	private int price;
	
	public Product1(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product1 other = (Product1) obj;
		return Objects.equals(name, other.name) && price == other.price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
