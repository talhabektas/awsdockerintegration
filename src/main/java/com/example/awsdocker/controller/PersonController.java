package com.example.awsdocker.controller;
import com.example.awsdocker.models.Person;
import com.example.awsdocker.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/")
    public String getAllPersons(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("person", new Person());
        return "add-person";
    }

    @PostMapping("/save")
    public String savePerson(@ModelAttribute Person person) {
        personRepository.save(person);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        model.addAttribute("person", personRepository.findById(id).orElseThrow());
        return "update-person";
    }

    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable Integer id, @ModelAttribute Person person) {
        person.setId(id);
        personRepository.save(person);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Integer id) {
        personRepository.deleteById(id);
        return "redirect:/";
    }
}