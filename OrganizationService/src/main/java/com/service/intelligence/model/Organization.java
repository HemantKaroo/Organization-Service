package com.service.intelligence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organization")
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orgid")
	private long orgId;

	@Column(name = "name", length = 100)
	private String name;

	@Column(name = "address", length = 300)
	private String address;

	@Column(name = "phoneone", length = 50)
	private String phoneOne;

	@Column(name = "phonetwo", length = 50)
	private String phoneTwo;

	@Column(name = "emailone", length = 256)
	private String emailOne;

	@Column(name = "emailtwo", length = 256)
	private String emailTwo;

	@Column(name = "city", length = 50)
	private String city;

	@Column(name = "state", length = 50)
	private String state;

	@Column(name = "country", length = 50)
	private String country;

	@Column(name = "zipcode", length = 50)
	private String zipcode;

	@Column(name = "active", length = 50)
	private String active;

	@Column(name = "createbyid", length = 20)
	private long createById;

	@Column(name = "updatebyid", length = 20)
	private long updateById;

	@Column(name = "createdate")
	private Date createDate;

	@Column(name = "updatedate")
	private Date updateDate;

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

	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
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

	public Organization(long orgId, String name, String address, String phoneOne, String phoneTwo, String emailOne,
			String emailTwo, String city, String state, String country, String zipcode, String active, long createById,
			long updateById, Date createDate, Date updateDate) {
		super();
		this.orgId = orgId;
		this.name = name;
		this.address = address;
		this.phoneOne = phoneOne;
		this.phoneTwo = phoneTwo;
		this.emailOne = emailOne;
		this.emailTwo = emailTwo;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.active = active;
		this.createById = createById;
		this.updateById = updateById;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public Organization() {
		super();
	}

}
