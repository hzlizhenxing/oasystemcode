package com.zszd.ai.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 评论
 * @author lizx 20180103
 *
 */
public class Comment {

	private int id;
	private int postId;
	private String userName;
	private String userIP;
	private String content;
	private Date commentDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserIP() {
		return userIP;
	}
	public void setUserIP(String userIP) {
		this.userIP = userIP;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(commentDate);
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	
}
