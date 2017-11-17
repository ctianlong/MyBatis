package cn.tongjilab.mybatis.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Article {

	private Integer id;
	private String title;
	private String content;
	private Author author;
	private List<Comment> comments;
	private LocalDateTime createTime;
	private LocalDateTime modifyTime;
	
	public Article() {
	}

	
	public Article(String title, String content, Author author, LocalDateTime createTime,
			LocalDateTime modifyTime) {
		this.title = title;
		this.content = content;
		this.author = author;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public LocalDateTime getCreateTime() {
		return createTime;
	}
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
	public LocalDateTime getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(LocalDateTime modifyTime) {
		this.modifyTime = modifyTime;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + ", comments="
				+ comments + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
	}
	
}
