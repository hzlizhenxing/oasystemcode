package com.zszd.ai.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 系统用户
 * @author lizx 20180103
 *
 */
public class SysUser implements Serializable {

	
	private static final long serialVersionUID = 1134483197940053257L;
	
	private int  id;
	private String name;
	private String password;
	private Date registerDate;
	private Date lastloginDate;
	private int logincount;
	private String loginIPaddress;
	private String headPath;
	private String isOnline;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegisterDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(registerDate);
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getLastloginDate() {
		if(lastloginDate!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			return sdf.format(lastloginDate);
		}
		return null;
		
	}
	public void setLastloginDate(Date lastloginDate) {
		this.lastloginDate = lastloginDate;
	}
	public int getLogincount() {
		return logincount;
	}
	public void setLogincount(int logincount) {
		this.logincount = logincount;
	}
	public String getLoginIPaddress() {
		return loginIPaddress;
	}
	public void setLoginIPaddress(String loginIPaddress) {
		this.loginIPaddress = loginIPaddress;
	}
	public String getHeadPath() {
		return headPath;
	}
	public void setHeadPath(String headPath) {
		this.headPath = headPath;
	}
	public String getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
