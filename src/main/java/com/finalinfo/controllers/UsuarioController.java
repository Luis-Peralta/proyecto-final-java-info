package com.finalinfo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController{

    @GetMapping("/")
    public String hello(){
        return "Hola Mundo";
    }
}