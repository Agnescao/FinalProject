package model;

public class Book {
   private int id;
   private String bookname;
   private double price;
   private String author;
   private String publish;
   private int amount;
   private int shoppingnums=1;

public Book(int id, String bookname, double price, String author,
		String publish, int amount, int shoppingnums) {
	super();
	this.id = id;
	this.bookname = bookname;
	this.price = price;
	this.author = author;
	this.publish = publish;
	this.amount = amount;
	this.shoppingnums = shoppingnums;
}
public Book(int id, String bookname, double price, String author, String publish,int amount) {
	this.id = id;
	this.bookname = bookname;
	this.price = price;
	this.author = author;
	this.publish = publish;
	this.amount = amount;
}
public Book() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPublish() {
	return publish;
}
public void setPublish(String publish) {
	this.publish = publish;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public int getShoppingnums() {
	return shoppingnums;
}
public void setShoppingnums(int shoppingnums) {
	this.shoppingnums = shoppingnums;
}
   
}
