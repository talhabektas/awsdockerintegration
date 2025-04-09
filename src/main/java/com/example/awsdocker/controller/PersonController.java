package com.example.awsdocker.controller;
import com.example.awsdocker.models.Person;
import com.example.awsdocker.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String savePerson(@ModelAttribute Person person, RedirectAttributes redirectAttributes) {
        try {
            personRepository.save(person);
            redirectAttributes.addFlashAttribute("successMessage", "Kişi başarıyla kaydedildi!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Hata: " + e.getMessage());
        }
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        model.addAttribute("person", personRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Geçersiz kişi ID: " + id)));
        return "update-person";
    }

    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable Integer id, @ModelAttribute Person person,
                               RedirectAttributes redirectAttributes) {
        try {
            person.setId(id);
            personRepository.save(person);
            redirectAttributes.addFlashAttribute("successMessage", "Kişi bilgileri güncellendi!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Hata: " + e.getMessage());
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            personRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Kişi silindi!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Hata: " + e.getMessage());
        }
        return "redirect:/";
    }
}