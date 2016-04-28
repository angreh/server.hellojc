package com.phillo.produtos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Greh on 4/24/2016.
 */
@Controller
public class produtos
{
    @RequestMapping(value = "/produtos")
    public String home()
    {
        return "produtos";
    }
}
