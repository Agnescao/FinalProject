package model;


public class User {

    private  int id;

	private String password;
	
	private String name;

	private String gender;

	private String address;

	private String telphone;

	private String email;
	
	private int grade;
	
	public User(int id,String name,String password, String gender,String address, String telphone, String email, int grade) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.telphone = telphone;
		this.email = email;
		this.grade = grade;
	}

	public User(String name, String password, String gender, String address,
			String telphone, String email, int grade) {
		super();
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.telphone = telphone;
		this.email = email;
		this.grade = grade;
	}

	public User(String name, String password) {
		super();
		this.password = password;
		this.name = name;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	
	

	
}
