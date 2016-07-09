package com.phillo.produtos.controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

@Controller
public class Product {

	@RequestMapping(value = "/list")
	public ModelAndView List() {
		// pega hash de produtos
		Producto pro = new Producto();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
			      "jdbc:mysql://localhost:3306/piserver;user=piola;password=");
		EntityManager em = emf.createEntityManager();
		try {
			em.persist(pro.getListaProducto());
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			em.close();
		}


		// transforma hash em JSON
		Gson gson = new Gson();
		String hashJSON = gson.toJson(pro.getListaProducto());

		ModelAndView returnFile = new ModelAndView("returnFile", "Return", hashJSON);
		return returnFile;
	}

//	public static String queryExec(String query) {
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		Map<Integer, Producto> unico = new HashMap<>();
//		try {
//			// new com.mysql.jdbc.Driver();
//			Class.forName("com.mysql.jdbc.Driver").newInstance();
//			// conn =
//			// DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=");
//			String connectionUrl = "jdbc:mysql://localhost:3306/piserver";
//			String connectionUser = "piola";
//			String connectionPassword = "";
//			conn = (Connection) DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
//			stmt = (Statement) conn.createStatement();
//			rs = stmt.executeQuery(query);
//
//			Producto pro = new Producto();
//		return	null;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			try {
//				if (stmt != null)
//					stmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}Producto pr = null ;
//		for (Integer i : unico.keySet()) {
//			pr = unico.get(i);
//			
//		}
//		return pr.toString();
//	}

}
