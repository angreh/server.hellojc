package com.phillo.produtos.model;

import java.io.Serializable;

public class Produto implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Long produtoId;
    private String name;
    private String price;

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
