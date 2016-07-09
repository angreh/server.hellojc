package com.phillo.produtos.controller;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Table;

import antlr.collections.List;

@Entity
@Table(name = "product")
public class Producto {
	
	@Id
	private Integer id;
	
	private String name;
	
	private String descripcion;
	
	private Date data;
	
	private EntityManager em;

	public Producto(Integer id, String name, String descripcion, Date data) {
		super();
		this.id = id;
		this.name = name;
		this.descripcion = descripcion;
		this.data = data;
	}

	public Producto() {
		super();
	}
	
	public Collection<Producto> getListaProducto(){
		Query q = em.createQuery("SELECT * FROM product");
		List l = (List) q.getResultList();
		return (Collection<Producto>) l;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", name=" + name + ", descripcion=" + descripcion + ", data=" + data + "]";
	}

}
