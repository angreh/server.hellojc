package com.phillo.produtos.bo;

import com.phillo.produtos.dao.ProdutoDao;
import com.phillo.produtos.model.Produto;

public class ProdutoBo
{
    ProdutoDao produtoDao;

    public void setProdutoDao(ProdutoDao produtoDao)
    {
        this.produtoDao = produtoDao;
    }

    public void save(Produto produto)
    {
        produtoDao.save(produto);
    }

    public void update(Produto produto)
    {
        produtoDao.update(produto);
    }

    public void delete(Produto produto)
    {
        produtoDao.delete(produto);
    }
}
