package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.entities.Teacher;
import com.uniovi.notaneitor.services.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {
    @Autowired
    private TeachersService teachersService;

    @RequestMapping("/professor/list")
    public String getList() {
        return teachersService.getTeachers().toString();
    }

    @RequestMapping(value= "/professor/add", method=RequestMethod.POST)
    public String setTeacher(@ModelAttribute Teacher teacher) {
        teachersService.addTeacher(teacher);
        return "Ok";
    }

    @RequestMapping(value= "/professor/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        teachersService.deleteTeacher(id);
        return "Teacher with id: " + id + " has been deleted";
    }

    @RequestMapping(value= "/professor/details/{id}")
    public String getDetail(@PathVariable Long id) {
        return teachersService.getTeacher(id).toString();
    }

    @RequestMapping(value= "/professor/edit/{id}")
    public String getEdit(@PathVariable Long id, @ModelAttribute Teacher teacher) {
        teachersService.editTeacher(id, teacher);
        return "Teacher with id " + id + " edited";
    }
}
