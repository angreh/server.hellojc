package com.phillo.produtos.controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Test {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// conn =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=");
			String connectionUrl = "jdbc:mysql://localhost:3306/test";
			String connectionUser = "piola";
			String connectionPassword = "";
			conn = (Connection) DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user");
			while (rs.next()) {
				String id = rs.getString("id");
				String firstName = rs.getString("name");
				String lastName = rs.getString("number");
				System.out.println("ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
