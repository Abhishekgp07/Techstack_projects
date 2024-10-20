package com.qn.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Quntnex {
	private String name;
	private String username;
	private String password;
	private String email;
	private String qualification;
	private String cgpa;
	Connection con = null;

	public Quntnex(String name, String username, String password, String email, String qualification, String cgpa) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.qualification = qualification;
		this.cgpa = cgpa;
	}

	public Quntnex() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getCgpa() {
		return cgpa;
	}

	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}

	@Override
	public String toString() {
		return "Quntnex [name=" + name + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", qualification=" + qualification + ", cgpa=" + cgpa + "]";
	}

	{
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuntNex", "root", "Abhi@1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int QuntNexRegister() {
		try {
			String s = "insert into quntnex values(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, name);
			pstmt.setString(2, username);
			pstmt.setString(3, password);
			pstmt.setString(4, email);
			pstmt.setString(5, qualification);
			pstmt.setString(6, cgpa);

			int rows = pstmt.executeUpdate();
			return rows;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	public int QuntNexLogin() {
		try {
			String s = "select * from quntnex where username=?";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, username);
			ResultSet res = pstmt.executeQuery();
			if (res.next()) {
				if (password.equals(res.getString(3))) {
					return 1;
				} else {
					return 0;
				}
			} else {
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}
}
