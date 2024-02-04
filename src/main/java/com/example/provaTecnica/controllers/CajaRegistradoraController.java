package com.example.provaTecnica.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cajaRegistradora")
public class CajaRegistradoraController {

    @GetMapping
    public String getSaldoCaja() {
        return "pages/index.html";
    }
}