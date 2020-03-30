package com.example.demo.vo;

public class MemberVo {
	private String id;
	private String name;
	private String tel;
	private int age;
	private String pwd;
	private String email;
	
	public MemberVo(String id, String name, String tel, int age, String pwd, String email) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.age = age;
		this.pwd = pwd;
		this.email = email;
	}

	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
