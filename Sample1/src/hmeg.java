import java.util.*;

class Book
{
	private int id;
	private String name;
	private String author;
	private int price;
	
	public Book()
	{
		
	}
	
	public Book(int id,String name,String author,int price)
	{
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, id, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && id == other.id && Objects.equals(name, other.name)
				&& price == other.price;
	}
	
	
}

public class hmeg {
	public static void main(String args[]) {
		HashMap<Book, Integer> hs = new HashMap<>();
		hs.put(new Book(101,"cricket","dhoni",123) , 5);
		hs.put(new Book(101,"cricket","dhoni",123) , 6);
		hs.put(new Book(102,"cricket","joni",123) , 6);
		hs.put(new Book(103,"cricket","jhoni",123) , 7);
		hs.put(new Book(104,"cricket","dhoni",123) , 8);
		System.out.println(hs);
		//hs.stream()//.filter(x -> x.getName().startsWith("j")).forEach(n -> System.out.println(n));
//		.filter(x -> (x.getName().startsWith("j"))).forEach(p -> System.out.println(p));
		hs.forEach((x,y) -> System.out.println(x.getName()+" "+y));
	}

	
}
