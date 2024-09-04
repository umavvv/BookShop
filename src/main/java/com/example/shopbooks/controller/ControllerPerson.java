package com.example.shopbooks.controller;

import com.example.shopbooks.entity.Person;
import com.example.shopbooks.service.impl.PersonServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControllerPerson {
    private final PersonServiceImpl personServiceImpl;

    public ControllerPerson(PersonServiceImpl personServiceImpl) {
        this.personServiceImpl = personServiceImpl;
    }

    @GetMapping("/personList")
    public String findAll(Model model, Person person) {
        List<Person> personList = personServiceImpl.getAllEmployee();
        model.addAttribute("personList", personList);
        return "person-list";
    }

    @GetMapping("/register")
    public String registerEmployee(ModelAndView modelAndView, Person person) {
        modelAndView.addObject(new Person());
        return "person-save";
    }

    @PostMapping("/personSave")
    public ModelAndView saveEmployeeBD(ModelAndView modelAndView, Person person) {
        personServiceImpl.saveEmployee(person);
        modelAndView.setViewName("redirect:/personList");
        return modelAndView;
    }
    @GetMapping("/personDelete")
    public String deleteEmployeeBD(Model model, Long id) {
        personServiceImpl.findById(id);
        personServiceImpl.deleteEmployee(id);
        model.addAttribute("delete",id);
        return "redirect:/personList";
    }
}

