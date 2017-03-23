package cn.tongjilab.mybatis.entity;

import java.time.LocalDate;

public class Person {

	private int id;
	private String username;
	private LocalDate birthday;
	
	public Person() {
	}
	
	public Person(int id, String username, LocalDate birthday) {
		super();
		this.id = id;
		this.username = username;
		this.birthday = birthday;
	}

	public Person(String username, LocalDate birthday) {
		super();
		this.username = username;
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", username=" + username + ", birthday=" + birthday + "]";
	}
	
	
}
