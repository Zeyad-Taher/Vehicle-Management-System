package com.example.vehiclemanagementsystem.parameters.controller;

import com.example.vehiclemanagementsystem.parameters.model.Country;
import com.example.vehiclemanagementsystem.parameters.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public String getAll(Model model){
        List<Country> countries=countryService.getAll();
        model.addAttribute("countries",countries);
        return "parameters/countryList";
    }
    @GetMapping("/countryAdd")
    public String addCountry(){
        return "parameters/countryAdd";
    }
    @PostMapping("/countries")
    public String save(Country country) {
        countryService.save(country);
        return "redirect:/countries";
    }
    @RequestMapping(value = "/countries/delete/{id}",method = {RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        countryService.delete(id);
        return "redirect:/countries";
    }
    @GetMapping("/countries/edit/{id}")
    public String edit(@PathVariable Integer id,Model model){
        Country country=countryService.getById(id);
        model.addAttribute("country",country);
        return "parameters/countryEdit";
    }
    @RequestMapping(value = "/countries/update/{id}",method = {RequestMethod.GET,RequestMethod.PUT})
    public String update(Country country){
        countryService.save(country);
        return "redirect:/countries";
    }
    @GetMapping("/countries/details/{id}")
    public String details(@PathVariable Integer id,Model model){
        Country country=countryService.getById(id);
        model.addAttribute("country",country);
        return "parameters/countryDetails";
    }
}