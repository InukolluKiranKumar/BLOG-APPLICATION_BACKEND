package com.kiran;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private String author;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false, length=5000)
	private String content;
	
	private LocalDateTime createdAt;
	
	public Post() {
	}

	


	public Post(String author, String title, String content) {
		super();
		this.author = author;
		this.title = title;
		this.content = content;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}




	@Override
	public String toString() {
		return "Post [id=" + id + ", Author=" + author + ", title=" + title + ", content=" + content + ", createdAt="
				+ createdAt + "]";
	}

	

	

	
}
