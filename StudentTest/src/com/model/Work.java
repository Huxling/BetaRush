package com.work.model;

import java.io.InputStream;

/**
 * 
 * @author 
 *Ա��ʵ����
 */
public class Work {
	private int id;
	private String sn;//����
	private String name;
	private String password;
	private int clazzId;
	private String sex = "��";
	private String uid;
	private String money;
	private InputStream photo;//ͷ��
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public int getClazzId() {
		return clazzId;
	}
	public void setClazzId(int clazzId) {
		this.clazzId = clazzId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getuid() {
		return uid;
	}
	public void setuid(String uid) {
		this.uid = uid;
	}
	public String getmoney() {
		return money;
	}
	public void setmoney(String money) {
		this.money = money;
	}
	public InputStream getPhoto() {
		return photo;
	}
	public void setPhoto(InputStream photo) {
		this.photo = photo;
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
	
}
