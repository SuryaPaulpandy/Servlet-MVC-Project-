package com.qn.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

	public void setMarks1(int Marks1) {
		Marks1 = Marks1;
	}

	public int getMarks2() {
		return Marks2;
	}

	public void setMarks2(int Marks2) {
		Marks2 = Marks2;
	}

	public int getMarks3() {
		return Marks3;
	}

	public void setMarks3(int marks3) {
		Marks3 = Marks3;
	}

	public Student(int id, String name, int marks1, int marks2, int marks3) {
		super();
		this.id = id;
		this.name = name;
		Marks1 = Marks1;
		Marks2 = Marks2;
		Marks3 = Marks3;
	}

	public Student() {
		super();
	}

	public void getResult() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024", "root", "root");

			String s = "Select * from student id = ?";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();

			if (res.next()) {
				id = res.getInt(1);
				name = res.getString(2);
				Marks1 = res.getInt(3);
				Marks2 = res.getInt(4);
				Marks3 = res.getInt(5);
			}

		} catch (Exception e) {

		}
	}
}
