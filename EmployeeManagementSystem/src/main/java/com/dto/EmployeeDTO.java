package com.dto;

public class EmployeeDTO {
	
	private String eid;
	private String name;
	private String email;
	private String address;
	private String salary;
	
	public EmployeeDTO(String eid, String name, String email, String address, String salary) {
		super();
		this.eid = eid;
		this.name = name;
		this.email = email;
		this.address = address;
		this.salary = salary;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	
}
