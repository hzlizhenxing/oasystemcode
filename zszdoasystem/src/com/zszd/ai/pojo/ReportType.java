package com.zszd.ai.pojo;

public class ReportType {
	private Integer id;
	private String typename;//报告类型


	
	@Override
	public String toString() {
		return "ReportType [id=" + id + ", typename=" + typename + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}
	
	
	
}
