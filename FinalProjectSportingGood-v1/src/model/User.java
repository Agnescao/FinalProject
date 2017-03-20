package model;

import java.sql.SQLException;
import java.sql.Statement;

import dao.CartDAO;
import dao.CartDAO;

public class User  {
  private int id ;
	private String name ;
	private String password ;
	private String email ;
	private String phone ;
	private String address ;
	private String city;
	private Cart cart;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public User(int id, String name, String password, String address) {
	  this.id = id ;
    this.name = name;
    this.password = password ;
    this.address = address;
  }
	
	public User(String name, String password, String address) {
		this.name = name;
		this.password = password ;
		this.address = address;
	}

	
	public User(int id, String name, String password) {
		// TODO Auto-generated constructor stub
		 this.id = id ;
		    this.name = name;
		    this.password = password ;
	}

public User(String name, String password, String email, String phone,
			String address, String city) {
		this.name=name;
		this.password=password;
		this.email=email;
		this.phone=phone;
		this.address=address;
		this.city=city;
		// TODO Auto-generated constructor stub
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	 public Cart getCart() {
	      Cart loadedCart = null;
	      if (cart != null) {
	         return cart;
	      } else {
	         loadedCart = CartDAO.instance.getFromUserId(this.id);
	      }
	      return loadedCart;
	   }
	public void setCart(Cart cart) {
		// TODO Auto-generated method stub
		this.cart=cart;
		
	}
	
	
}
