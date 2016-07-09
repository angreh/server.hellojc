package com.phillo.produtos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class OlaMundoController {
	@RequestMapping(value = "/olaMundoSpring")
	public String home() {
		System.out.print("Executando a lógica co Spring MVC");
		return "home";
	}

	@RequestMapping(value = "/same")
	public ModelAndView same() {
		ModelAndView Same = new ModelAndView("same", "name", "Angreh");

		return Same;
	}

	@RequestMapping(value = "/mapteste")
	public ModelAndView mapteste() {
		Map<String, Object> map = new HashMap<>();
		map.put("nome", "Valor");
		map.put("nome2", "Valor2");

		ModelAndView MapTeste = new ModelAndView("mapteste", map);

		return MapTeste;
	}

	@RequestMapping(value = "/sisardo")
	public String openConectionBBDD() {
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
			rs = stmt.executeQuery("SELECT * FROM java");
			while (rs.next()) {
				Producto pro = new Producto();
				pro.setId(rs.getInt("id"));
				pro.setName(rs.getString("name"));
				System.out.println("ID: " + pro.getId() + ", First Name: " + pro.getName());
			}
			return "hola";
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
		return "conexao nao feita :(";
	}

}
