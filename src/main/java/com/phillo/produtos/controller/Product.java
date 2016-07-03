package com.phillo.produtos.controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

@Controller
public class Product{

	@RequestMapping(value = "/list")
	public ModelAndView List()
	{
		//pega hash de produtos
		HashMap<String, Object> products = queryExec("SELECT * FROM product");
		
		//transforma hash em JSON
		Gson gson = new Gson();
		String hashJSON = gson.toJson(products);
		
		ModelAndView returnFile = new ModelAndView( "returnFile", "Return", hashJSON );
		return returnFile;
	}
	
	public static HashMap<String, Object> queryExec(String query) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// conn =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=");
			String connectionUrl = "jdbc:mysql://localhost:3306/piserver";
			String connectionUser = "piola";
			String connectionPassword = "";
			conn = (Connection) DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery(query);
			HashMap<String, Object> mapping = new HashMap<>();
			while (rs.next()) {
				mapping.put("ID", rs.getString("id"));
				mapping.put("name", rs.getString("name"));
				mapping.put("description", rs.getString("description"));	
			}
			return mapping; 
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
		return null;
	}

}
