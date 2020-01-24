package com.howtodoinjava.demo.controller;

import com.howtodoinjava.demo.ClassForOutDataFromJSP.StudentFromJSP;
import com.howtodoinjava.demo.model.Student;
import com.howtodoinjava.demo.repositories.StudentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentRepositories studentRepositories;

    @RequestMapping(path = "/jpa/students", method = RequestMethod.GET)
//    public ModelAndView getStudents(){
//        List<Student> students = studentRepositories.findAll();
//        ModelAndView modelAndView = new ModelAndView("student");
//        modelAndView.addObject("studentsFromServer", students);
//        return modelAndView;
//    }
    public ModelAndView getStudents(@RequestParam(required = false, name = "name") String name) {
        List<Student> students = null;

        if (name != null) {
            students = studentRepositories.findAllByName(name);
        } else {
            students = studentRepositories.findAll();
        }
        ModelAndView modelAndView = new ModelAndView("student");
        modelAndView.addObject("studentsFromServer", students);
        return modelAndView;
    }

    @RequestMapping(path = "/jpa/students", method = RequestMethod.POST)
    public String addUser(StudentFromJSP studentFromJSP) {
        Student newStudent = Student.from(studentFromJSP);
        studentRepositories.save(newStudent);
        return "redirect:/jpa/students";
    }
}
