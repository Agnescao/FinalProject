package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.sql.Blob;

public class Product {
	
	private int id;
	private String name;
	private double price;
	private String description;
	private Category category;
	private int Cid;
    private InputStream inputstream;
    private String imagepath;
   
	
	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public Product(String name, double price, String description,
			 int cid, String path) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		
		Cid = cid;
		this.imagepath=path;
	}

	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Product(String name) {
		super();
		this.name = name;
	}

	public Product(String name,InputStream inputstream) {
		this.name=name;
		this.inputstream=inputstream;
	}

	public Product(int productId, String name, Double price,
			String description, InputStream inputstream) {
		id=productId;
		this.name=name;
		this.price = price;
		this.description = description;
		this.inputstream=inputstream;
	}


	public Product() {
		
	}

	

	public Product(int productId, String name, InputStream image) {
		id=productId;
		this.name=name;
		inputstream=image;
	}

	public Product(int id, String name, String description,double price) {
		this.id=id;
		this.name=name;
		this.price = price;
		this.description = description;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	public int getCid() {
		return Cid;
	}

	public void setCid(int cid) {
		Cid = cid;
	}

	public InputStream getInputstream() {
		return inputstream;
	}

	public void setInputstream(InputStream inputstream) {
		
		this.inputstream=inputstream;
	}

	

	
   
}
