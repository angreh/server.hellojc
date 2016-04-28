package com.phillo.produtos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@Controller
public class OlaMundoController
{
    @RequestMapping(value = "/olaMundoSpring")
    public String home()
    {
        System.out.print("Executando a lógica co Spring MVC");
        return "home";
    }

    @RequestMapping(value = "/same")
    public ModelAndView same()
    {
        ModelAndView Same = new ModelAndView("same", "name", "Angreh");

        return Same;
    }

    @RequestMapping(value = "/mapteste")
    public ModelAndView mapteste()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("nome", "Valor");
        map.put("nome2", "Valor2");

        ModelAndView MapTeste = new ModelAndView("mapteste", map);

        return MapTeste;
    }
}
