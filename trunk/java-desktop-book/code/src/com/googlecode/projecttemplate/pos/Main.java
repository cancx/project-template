/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.googlecode.projecttemplate.pos;

import com.googlecode.projecttemplate.pos.model.Product;
import com.googlecode.projecttemplate.pos.service.ProductService;
import com.googlecode.projecttemplate.pos.service.SalesService;
import com.googlecode.projecttemplate.pos.service.SecurityService;
import com.googlecode.projecttemplate.pos.ui.MainFrame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ifnu
 */
public class Main {

    private static SecurityService securityService;
    private static SalesService salesService;
    private static ProductService productService;
    private static MainFrame frame;

    public static SecurityService getSecurityService() {
        return securityService;
    }

    public static SalesService getSalesService() {
        return salesService;
    }

    public static ProductService getProductService() {
        return productService;
    }

    public static MainFrame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext applicationContext =
                        new ClassPathXmlApplicationContext("applicationContext.xml");
                securityService = (SecurityService) applicationContext.getBean("securityService");
                salesService = (SalesService) applicationContext.getBean("salesService");
                productService = (ProductService) applicationContext.getBean("productService");
                frame = new MainFrame();
                frame.setVisible(true);
            }
        });

    }
}


























