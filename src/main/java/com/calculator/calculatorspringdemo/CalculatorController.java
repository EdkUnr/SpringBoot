package com.calculator.calculatorspringdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String add(@RequestParam(value = "num1") Double num1, @RequestParam(value = "num2") Double num2) {
        if (num1 == null || num2 == null) {
            return "Ошибка: один из параметров не задан";
        }
        double result = calculatorService.add(num1, num2);
        return num1 + " + " + num2 + " = " + result;
    }

    @GetMapping("/minus")
    public String subtract(@RequestParam(value = "num1") Double num1, @RequestParam(value = "num2") Double num2) {
        if (num1 == null || num2 == null) {
            return "Ошибка: один из параметров не задан";
        }
        double result = calculatorService.subtract(num1, num2);
        return num1 + " − " + num2 + " = " + result;
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1") Double num1, @RequestParam(value = "num2") Double num2) {
        if (num1 == null || num2 == null) {
            return "Ошибка: один из параметров не задан";
        }
        double result = calculatorService.multiply(num1, num2);
        return num1 + " * " + num2 + " = " + result;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(value = "num1") Double num1, @RequestParam(value = "num2") Double num2) {
        if (num1 == null || num2 == null) {
            return "Ошибка: один из параметров не задан";
        }
        if (num2 == 0) {
            return "Ошибка: деление на ноль";
        }
        double result = calculatorService.divide(num1, num2);
        return num1 + " / " + num2 + " = " + result;
    }
}

