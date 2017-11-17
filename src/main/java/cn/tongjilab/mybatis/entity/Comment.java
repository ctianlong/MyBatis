package cn.tongjilab.mybatis.entity;

import java.time.LocalDateTime;

public class Comment {

	private Integer id;
	private String content;
	private Author author;
	private Article article;
	private LocalDateTime createTime;
	
	public Comment() {
	}

	public Comment(String content, Author author, Article article, LocalDateTime createTime) {
		this.content = content;
		this.author = author;
		this.article = article;
		this.createTime = createTime;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public LocalDateTime getCreateTime() {
		return createTime;
	}
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", author=" + author + ", article=" + article
				+ ", createTime=" + createTime + "]";
	}
	
	
	
}
