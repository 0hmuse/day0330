package com.example.demo.vo;

public class EmpVo {
	private int eno;
	private String ename;
	private String jab;
	private int sal;
	private int comm;
	private int mgr;
	private String hitrdate;
	private int dno;
	private String email;
	
	public EmpVo(int eno, String ename, String jab, int sal, int comm, int mgr, String hitrdate, int dno,
			String email) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.jab = jab;
		this.sal = sal;
		this.comm = comm;
		this.mgr = mgr;
		this.hitrdate = hitrdate;
		this.dno = dno;
		this.email = email;
	}

	public EmpVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJab() {
		return jab;
	}

	public void setJab(String jab) {
		this.jab = jab;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public String getHitrdate() {
		return hitrdate;
	}

	public void setHitrdate(String hitrdate) {
		this.hitrdate = hitrdate;
	}

	public int getDno() {
		return dno;
	}

	public void setDno(int dno) {
		this.dno = dno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
