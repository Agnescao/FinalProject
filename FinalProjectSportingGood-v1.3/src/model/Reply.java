package model;

public class Reply {
	
	private int id;
	private int commentId;
	private String reply;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Reply(int id, int commentId, String reply) {
		super();
		this.id = id;
		this.commentId = commentId;
		this.reply = reply;
	};
	

}
