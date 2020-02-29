package com.example.PCcomponentsShop;

import Model.CPU;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class Controller {
    CPU cpuProduct = new CPU();
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Hello! Welcome to the PCcomponentsShop!";
    }
    @RequestMapping(value = "/info-CPU", method = RequestMethod.GET)
    public String infoCPU() {
        cpuProduct.setName("Intel Core i9-7960X");
        cpuProduct.showInfo();
        return cpuProduct.toString();
    }

    @RequestMapping(value="/buy-CPU", method=RequestMethod.POST)
    public String buyCPU() {
        cpuProduct.buy();
        return "Thank you for buying this product!";
    }
}