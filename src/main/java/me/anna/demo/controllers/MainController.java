package me.anna.demo.controllers;

import me.anna.demo.StudentRepository;
import me.anna.demo.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    StudentRepository studentRepository;

    // Display the home page
//    @RequestMapping("/")
    @GetMapping("/")
    public String showIndex()
    {
        return "index";
    }

    // Display the login page
    @RequestMapping("/login")
//    @GetMapping("/login")
    public String login(){
//        return "allStudents";
        return "login";
    }

    @GetMapping("/allStudents")
    public String showall(Model model) {

        model.addAttribute("allstudents", studentRepository.findAll());
        return "allStudents";
    }


    // Allow user to enter Student's information
    @GetMapping("/enterStudent")
    public String addStudent(Model model)
    {
        model.addAttribute("newStudent", new Student());
        return "enterStudent";
    }

    // Validate entered information and if it is valid display the result
    @PostMapping("/enterStudent")
    public String postStudent(@Valid @ModelAttribute("newStudent") Student student, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            return "enterStudent";
        }

        studentRepository.save(student);
        return "resultStudent";
    }

//    @GetMapping("/allStudents")
//    public String showall(Model model) {
//
//        model.addAttribute("allstudents", studentRepository.findAll());
//        return "allStudents";
//    }

}
