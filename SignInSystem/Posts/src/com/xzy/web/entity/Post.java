package com.xzy.web.entity;

import java.io.Serializable;
import java.util.List;

public class Post implements Serializable{
    private int postId;//����id
    private String postDatetime;//����ʱ��
    private int postSupports;//���ӵĵ�����
    private int postComments;//���ӵ�������
    private String postContentFile;//�洢�������ݵ��ļ�
    private User postOwner;//������
    private List<Comment> postCommentList;

    
    public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

    public Post(int postId, String postDatetime, int postSupports, int postComments, String postContentFile,
			User postOwner, List<Comment> postCommentList) {
		super();
		this.postId = postId;
		this.postDatetime = postDatetime;
		this.postSupports = postSupports;
		this.postComments = postComments;
		this.postContentFile = postContentFile;
		this.postOwner = postOwner;
		this.postCommentList = postCommentList;
	}

	public Post(String postContentFile, User postOwner) {
		super();
		this.postContentFile = postContentFile;
		this.postOwner = postOwner;
	}


	public int getPostId() {
		return postId;
	}


	public void setPostId(int postId) {
		this.postId = postId;
	}


	public String getPostDatetime() {
		return postDatetime;
	}


	public void setPostDatetime(String postDatetime) {
		this.postDatetime = postDatetime;
	}


	public int getPostSupports() {
		return postSupports;
	}


	public void setPostSupports(int postSupports) {
		this.postSupports = postSupports;
	}


	public int getPostComments() {
		return postComments;
	}


	public void setPostComments(int postComments) {
		this.postComments = postComments;
	}


	public String getPostContentFile() {
		return postContentFile;
	}


	public void setPostContentFile(String postContentFile) {
		this.postContentFile = postContentFile;
	}


	public User getPostOwner() {
		return postOwner;
	}


	public void setPostOwner(User postOwner) {
		this.postOwner = postOwner;
	}
	


	public List<Comment> getPostCommentList() {
		return postCommentList;
	}


	public void setPostCommentList(List<Comment> postCommentList) {
		this.postCommentList = postCommentList;
	}


	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postDatetime=" + postDatetime + ", postSupports=" + postSupports
				+ ", postComments=" + postComments + ", postContentFile=" + postContentFile + ", postOwner=" + postOwner
				+ ", postCommentList=" + postCommentList + "]";
	}
    
}
