package ar.edu.teclab.service;

import ar.edu.teclab.entity.Matter_entity;
import ar.edu.teclab.entity.Teacher_entity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    private List<Teacher_entity> teacher = new ArrayList<Teacher_entity>();
    public void NewTeacher(String fullname, Long DNI, String email, String title, Matter_entity matter) {
        Teacher_entity Teacher = new Teacher_entity(fullname, DNI, email, title);
        if (matter != null){
            Teacher.setMatter(matter);
        }

        this.teacher.add(Teacher);
    }

    public List<Teacher_entity> getTeacher() {
        return teacher;
    }

    public Teacher_entity getOneTeacher(Long id) {
        return this.teacher.stream().filter( (Teacher_entity e) -> e.getID() == id).findFirst().get();
    }
}
