package model;

public class Order {
	private int id;
	private int quantity;
	private double totalPrice;
	private Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Order(Product product) {

		this.product = product;
		quantity = 1;

	}

	public Order(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}

	

	public Order(int id,int quantity, double totalPrice, Product product) {
		super();
		this.id=id;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void increaseQuantity() {
		quantity++;
	}

	public void decreaseQuantity() {
		quantity--;
	}

	public double getTotal() {

		double totalPrice = (this.getQuantity() * product.getPrice());
		return totalPrice;
	}

}
