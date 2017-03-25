package cn.tongjilab.mybatis.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Author {

	private Integer id;
	private String username;
	private String nickname;
	private LocalDate birthday;
	private LocalDateTime registerTime;
	
	public Author() {
	}
	
	public Author(String username, String nickname, LocalDate birthday, LocalDateTime registerTime) {
		super();
		this.username = username;
		this.nickname = nickname;
		this.birthday = birthday;
		this.registerTime = registerTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public LocalDateTime getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(LocalDateTime registerTime) {
		this.registerTime = registerTime;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", username=" + username + ", nickname=" + nickname + ", birthday=" + birthday
				+ ", registerTime=" + registerTime + "]";
	}
	
	
}
