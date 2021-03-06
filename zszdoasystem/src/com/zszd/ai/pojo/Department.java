package com.zszd.ai.pojo;


public class Department {
	private int id;
	private String name;
	private int companyId;
	private String telephone;
	private String fax;
	private String buildTime;
	private String address;
	private String companyName;
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getBuildTime()  {
		return buildTime;
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		// return sdf.format(buildTime);
	}
	public void setBuildTime(String buildTime) {
		this.buildTime = buildTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
