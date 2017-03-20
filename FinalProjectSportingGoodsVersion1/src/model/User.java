package model;

import java.sql.SQLException;
import java.sql.Statement;

public class User  {
  private int id ;
	private String name ;
	private String password ;
	private String address ;
	
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
	
	
}
