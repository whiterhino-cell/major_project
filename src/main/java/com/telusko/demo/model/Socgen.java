package com.telusko.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Socgen {
@Id
	private String id;
	private String date;
	private String mail;
	private String name;
	private int seat;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "\nSocGen{" +
				"id=" + id +
				", date='" + date + '\'' +
				", mail='" + mail + '\'' +
				", name='" + name + '\'' +
				", seat=" + seat +
				'}';
	}
}
