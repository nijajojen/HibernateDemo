package com.binoy.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/*
 * instance field should be given in a class.
 */

//Map user table to this user class.



@Entity
@Table(name= "User")
public class User {
	
	
	@Id
	@Column(name= "id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="phone")
	private String phone;
	
	@Column(name="dob")
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy="user")
	private List<Address> addressList;

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	public static void main(String[] args) {
		
		
	}

}
