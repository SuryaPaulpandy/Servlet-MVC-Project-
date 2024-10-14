package com.qn.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Student {
	private int id;
	private String name;
	private int Marks1;
	private int Marks2;
	private int Marks3;
	
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
	public int getMarks1() {
		return Marks1;
	}
	public void setMarks1(int marks1) {
		Marks1 = marks1;
	}
	public int getMarks2() {
		return Marks2;
	}
	public void setMarks2(int marks2) {
		Marks2 = marks2;
	}
	public int getMarks3() {
		return Marks3;
	}
	public void setMarks3(int marks3) {
		Marks3 = marks3;
	}
	
	
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", Marks1=" + Marks1 + ", Marks2=" + Marks2 + ", Marks3="
				+ Marks3 + "]";
	}
	
	public int addResult() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024", "root", "root");

			String s = "Insert into student values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, Marks1);
			pstmt.setInt(4, Marks2);
			pstmt.setInt(5, Marks3);
			int rows = pstmt.executeUpdate();
			return rows;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
