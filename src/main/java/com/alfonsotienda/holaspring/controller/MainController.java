package com.alfonsotienda.holaspring.controller;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.aspectj.apache.bcel.classfile.Module.Require;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * MainController
 */

@Controller
public class MainController {

    @GetMapping("/")
    @ResponseBody
    public String holaMundo(@RequestParam("nombre") String name, @RequestParam("edad") Integer edad) {
        return "Hola " + name + " tienes " + edad + "años";
    }

    @GetMapping("/ingles")
    @ResponseBody
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/nuevo")
    public ModelAndView helloHTML() {
        ModelAndView respuesta = new ModelAndView("hello");
        String msg = "Hola Mundo html";
        respuesta.addObject("mensaje", msg);
        return respuesta;
    }

    @GetMapping("/calculadora")
    public ModelAndView calculadoraHTML() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("mensaje", "");
        return modelAndView;
    }

    @PostMapping("/calculadora")
    public ModelAndView calculadoraHTMLPost(@RequestParam("operando1") Integer operando1,
            @RequestParam(value = "operando2", required = false) Integer operando2,
            @RequestParam("operacion") String operacion) {

        ModelAndView modelAndView = new ModelAndView("hello");

        String resultado = calcula(operando1, operacion, operando2);

        modelAndView.addObject("mensaje", "El resultado es " + resultado);

        return modelAndView;
    }

    private String calcula(Integer operando1, String operacion, Integer operando2) {
        double resultado = 0.0;
        switch (operacion) {
        case "suma":
            resultado = operando1 + operando2;
            break;
        case "resta":
            resultado = operando1 - operando2;
            break;
        case "multiplicacion":
            resultado = operando1 * operando2;
            break;
        case "division":
            resultado = operando1 / operando2;
            break;
        case "^":
            resultado = (int) Math.pow(operando1, operando2);
            break;
        case "mod":
            resultado = operando1 % operando2;
            break;
        case "raiz":
            resultado = Math.sqrt(operando1);
            break;
        default:
            return "No coinciden el operador";
        }
        return operando1 + " " + operacion + " " + operando2 + " = " + resultado;
    }
}