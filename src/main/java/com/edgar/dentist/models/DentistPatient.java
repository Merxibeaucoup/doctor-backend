package com.edgar.dentist.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class DentistPatient {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message ="name can not be empty")
	@Column(nullable = false)
	private String name;
	
	@NotBlank(message ="number can not be empty")
	@Column(nullable = false)
	private String number;
	
	@NotBlank(message ="email can not be empty")
	@Column(nullable = false)
	@Email
	private String email;
	
	@CreationTimestamp // sets to current vm time stamp
	@Temporal(TemporalType.TIMESTAMP)// get sql time stamp 
	@JsonFormat(pattern ="MM-dd-yyyy")
	@Column(nullable = true)
	private Date creationDate; // date created
	
	@JsonFormat(pattern ="MM-dd-yyyy")
	@Column(nullable = false)
	private String date;
	
	
	@Column(columnDefinition = "TEXT", nullable = true)
	private String message;
	
	@Column(nullable = false)
	private String service;
	
	@Column(nullable = false)
	private String time;
	
	public DentistPatient(){
		
	}

	public DentistPatient(Long id, @NotBlank(message = "name can not be empty") String name,
			@NotBlank(message = "number can not be empty") String number,
			@NotBlank(message = "email can not be empty") @Email String email, Date creationDate, String date,
			String message, String service, String time) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.email = email;
		this.creationDate = creationDate;
		this.date = date;
		this.message = message;
		this.service = service;
		this.time = time;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "DentistPatient [id=" + id + ", name=" + name + ", number=" + number + ", email=" + email
				+ ", creationDate=" + creationDate + ", date=" + date + ", message=" + message + ", service=" + service
				+ ", time=" + time + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(creationDate, date, email, id, message, name, number, service, time);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DentistPatient other = (DentistPatient) obj;
		return Objects.equals(creationDate, other.creationDate) && Objects.equals(date, other.date)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(message, other.message) && Objects.equals(name, other.name)
				&& Objects.equals(number, other.number) && Objects.equals(service, other.service)
				&& Objects.equals(time, other.time);
	}

	

	

	
}