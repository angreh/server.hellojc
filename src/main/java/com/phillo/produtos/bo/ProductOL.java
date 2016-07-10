package com.phillo.produtos.bo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by angre on 7/10/2016.
 */

@DatabaseTable(tableName = "java")
public class ProductOL
{
    @DatabaseField(canBeNull = false)
    public String name;

    @DatabaseField(canBeNull = false)
    public Integer number;

    ProductOL()
    {

    }
}
