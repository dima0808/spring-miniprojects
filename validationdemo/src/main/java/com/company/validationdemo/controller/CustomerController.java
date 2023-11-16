package com.company.validationdemo.controller;

import com.company.validationdemo.entity.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/form")
    public String getForm(Model model) {

        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute(name = "customer") Customer customer, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "customer-form";
        } else {
            return "confirmation";
        }
    }
}