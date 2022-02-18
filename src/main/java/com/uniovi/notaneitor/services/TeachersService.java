package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Teacher;
import com.uniovi.notaneitor.repositories.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeachersService {

    @Autowired
    private TeachersRepository teachersRepository;

    public void addTeacher(Teacher teacher)
    {
        teachersRepository.save(teacher);
    }

    public Teacher getTeacher(Long id) {
        return teachersRepository.findById(id).get();
    }

    public List<Teacher> getTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        teachersRepository.findAll().forEach(teachers::add);
        return teachers;
    }

    public void deleteTeacher(Long id) {
        teachersRepository.deleteById(id);
    }

    public void editTeacher(Long id, Teacher teacher) {
        Teacher t = teachersRepository.findById(id).get();
        t.setName(teacher.getName());
        t.setDni(teacher.getSurnames());
        t.setSurnames(teacher.getSurnames());
        t.setCategory(teacher.getCategory());
        teachersRepository.save(t);
    }


}
