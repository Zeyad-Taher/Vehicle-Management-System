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
}