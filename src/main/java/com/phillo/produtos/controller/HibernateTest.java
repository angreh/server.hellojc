package com.phillo.produtos.controller;

import com.phillo.produtos.model.Employee;
import com.phillo.produtos.model.Employee1;
import com.phillo.produtos.util.HibernateUtil;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class HibernateTest
{
    @RequestMapping(value = "/hibernatetest")
    public ModelAndView mainTest()
    {
        //Employee emp = new Employee();
        Employee1 emp = new Employee1();

        emp.setName("Piola");
        emp.setRole("CEO");
        emp.setInsertTime(new Date());

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(emp);
        session.getTransaction().commit();

        ModelAndView HibernateTest = new ModelAndView( "hibernatetest", "valor", emp.getId() );

        HibernateUtil.getSessionFactory().close();

        return HibernateTest;
    }
}


