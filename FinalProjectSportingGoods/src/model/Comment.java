package model;

public class Comment {
	
	int id;
	String comment;
	String date;
	
	public Comment(int id, String comment, String date) {
		super();
		this.id = id;
		this.comment = comment;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	

}
