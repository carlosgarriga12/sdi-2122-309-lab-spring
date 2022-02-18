package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeachersService {

    private List<Teacher> teachers = new ArrayList<>();

    @PostConstruct
    public void init() {
        teachers.add(new Teacher(1L,"111",
                "Carlos",
                "Garriga Suárez", "Maths"));
        teachers.add(new Teacher(2L,"222",
                "Diego",
                "Martín Fernández", "History"));
        teachers.add(new Teacher(3L, "333",
                "Carmen",
                "Argüelles Villalba", "Marketing"));

    }

    public void addTeacher(Teacher teacher)
    {
        teachers.add(teacher);
    }

    public Teacher getTeacher(Long id) {
        for (Teacher t: teachers) {
            if(t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    public List<Teacher> getTeachers() {
        return this.teachers;
    }

    public void deleteTeacher(Long id) {
        for (Teacher t: teachers) {
            if(t.getId().equals(id)) {
                teachers.remove(t);
            }
        }
    }

    public void editTeacher(Long id, Teacher teacher) {
        for(Teacher t: teachers) {
            if(t.getId().equals(id)) {
                t.setName(teacher.getName());
                t.setCategory(teacher.getCategory());
                t.setDni(teacher.getSurnames());
                t.setId(teacher.getId());
                t.setSurnames(teacher.getSurnames());
            }
        }

    }


}
