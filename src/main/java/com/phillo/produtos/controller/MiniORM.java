package com.phillo.produtos.controller;

import com.google.gson.Gson;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.phillo.produtos.bo.ProductOL;

import java.util.Iterator;
import java.util.List;

/**
 * Created by angre on 7/10/2016.
 */
public class MiniORM
{
    public static void main(String[] args)
    {
        List<ProductOL> productOL = getAll();

        if(productOL == null)
        {
            System.out.println("Deu cáca. Provavelmente os dados do banco de dados estão errados");
            return;
        }

        Iterator<ProductOL> iterator = productOL.iterator();
        while (iterator.hasNext())
        {
            //retornando os valores separados
            ProductOL prod = iterator.next();
            System.out.println( "Nome: " + prod.name + " Número: " + prod.number );
        }

        //retornando JSON que é o formato esperado
        Gson gson = new Gson();
        String hashJSON = gson.toJson(productOL);

        System.out.println(hashJSON);

        //Usando função genérica
        List<ProductOL> prodG = getAllG(ProductOL.class);
        String json = gson.toJson(prodG);

        System.out.println(json);
    }

    public static List<ProductOL> getAll() {
        try {
            //faz conexão
            String databaseURL = "jdbc:mysql://localhost:3306/test";
            ConnectionSource conn = new JdbcConnectionSource(databaseURL, "root", "12345678");
            //cria DAO
            Dao<ProductOL, String> productDAO = DaoManager.createDao(conn, ProductOL.class);

            //função que pega todos os produtos
            List<ProductOL> productOL = productDAO.queryForAll();
            return productOL;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Função genérica para retornar todos os objetos da tabela
     *
     * @param file a classe do tipo de objeto que deve ser buscado
     * @return A lista de objetos resultantes da query
     */
    public static List getAllG(Class file)
    {
        try {
            //faz conexão
            String databaseURL = "jdbc:mysql://localhost:3306/test";
            ConnectionSource conn = new JdbcConnectionSource(databaseURL,"root","12345678");
            //cria DAO
            Dao dao = DaoManager.createDao(conn, file);

            //função que pega todos os itens
            List genericList = dao.queryForAll();

            conn.close();

            return genericList;

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
