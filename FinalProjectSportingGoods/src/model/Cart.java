package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	int id;
	String name;
	List<Order> items = new ArrayList<Order>();     
    
    int numberOfItems;// how many each items are
    double total;// total number of items in the cart
    
    
	public Cart(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cart() {
		
		numberOfItems =0;
		total = 0;
	}
	
	public Cart(int id, String name) {
		super();
		this.id = id;
		
	}
    
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	

	public void  addoder(Product product){
		Order order=new Order(product);
		items.add(order);
		order.increaseQuantity();
	}
	
	public List<Order> listOrder()
	{
		return items;
	}
	
	public void deleteOrder(Product product)
	{
		items.remove(product);
		
	}
	public void clear(){
		items.clear();
		numberOfItems =0;
		total = 0;
	}

	

	public List<Order> getItems() {
		// TODO Auto-generated method stub
		return items;
	}

	public double getTotalPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void setContents(List<Order> items2) {
		
		// TODO Auto-generated method stub
		
	}

   
   

	

	


	
    
    
    
    // -------------------------------------------------------
    //  Adds an order to the shopping cart.
    // -------------------------------------------------------
    /*public void addToCart(String productName, int quantity,int price )
    { 

        order temp = new order(productName, quantity, price);
        totalPrice += (price * quantity);
        orderCount += quantity;
        cart[orderCount] = temp;
        if(orderCount==capacity)
        {
            increaseSize();
        }
    }

	private void increaseSize() {
		// TODO Auto-generated method stub
		order[] temp = new order[capacity+3];
        for(int i=0; i < capacity; i++)
        {
            temp[i] = cart[i];
        }
        cart = temp; 
        temp = null;
        capacity = cart.length;
    }
	*/
}
