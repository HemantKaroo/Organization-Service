package com.service.intelligence.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.service.intelligence.customvalidator.InvalidEmail;
import com.service.intelligence.customvalidator.InvalidOrganizationName;

@InvalidEmail
@InvalidOrganizationName
public class OrganizationDTO {
	
	private long orgId;
	
	@Size(min = 2, max = 100, message = "Organization Name Should Have At Least 2 Characters")
	@NotEmpty(message = "Name Cannot Be Empty")
	private String name;

	@Size(min = 5, max = 300)
	@NotEmpty(message = "Address Cannot Be Empty")
	private String address;

	@Size(min = 10, max = 15)
	@NotEmpty(message = "Phone Number Cannot Be Empty")
	private String phoneOne;

	@Size(min = 10, max = 15)
	private String phoneTwo;

	@NotEmpty(message = "Email-Id Cannot Be Empty")
	@Size(min = 10, max = 300, message = "Email-ID Should Have At Least 10 Characters")
	@Pattern(regexp = "^(.+)@(.+)$", message = "Enter A Valid Email")
	private String emailOne;

	@Size(min = 10, max = 300, message = "Email-ID Should Have At Least 10 Characters")
	@Pattern(regexp = "^(.+)@(.+)$", message = "Enter A Valid Email")
	private String emailTwo;

	@Size(min = 2, max = 50)
	@NotEmpty(message = "City Cannot Be Empty")
	private String city;

	@Size(min = 2, max = 50)
	@NotEmpty(message = "State Cannot Be Empty")
	private String state;

	@Size(min = 2, max = 50)
	@NotEmpty(message = "Country Cannot Be Empty")
	private String country;

	@Size(min = 6)
	@NotEmpty(message = "Zipcode Cannot Be Empty")
	private String zipcode;

	private String active;

	private long createById;

	private long updateById;

	private Date createDate;

	private Date updateDate;
	
	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}

	public long getCreateById() {
		return createById;
	}

	public void setCreateById(long createById) {
		this.createById = createById;
	}

	public long getUpdateById() {
		return updateById;
	}

	public void setUpdateById(long updateById) {
		this.updateById = updateById;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneOne() {
		return phoneOne;
	}

	public void setPhoneOne(String phoneOne) {
		this.phoneOne = phoneOne;
	}

	public String getPhoneTwo() {
		return phoneTwo;
	}

	public void setPhoneTwo(String phoneTwo) {
		this.phoneTwo = phoneTwo;
	}

	public String getEmailOne() {
		return emailOne;
	}

	public void setEmailOne(String emailOne) {
		this.emailOne = emailOne;
	}

	public String getEmailTwo() {
		return emailTwo;
	}

	public void setEmailTwo(String emailTwo) {
		this.emailTwo = emailTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
