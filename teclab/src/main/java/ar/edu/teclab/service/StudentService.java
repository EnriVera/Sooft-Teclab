package ar.edu.teclab.service;

import ar.edu.teclab.dto.InputStudentDTO;
import ar.edu.teclab.entity.Student_entity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private List<Student_entity> student = new ArrayList<Student_entity>();

    public void AddStudent(InputStudentDTO student) {
        Student_entity NewStudent = new Student_entity(student.getFullName(), student.getDni(), student.getEmail());
        this.student.add(NewStudent);
    }


    public List<Student_entity> getAllStudent() {
        return this.student;
    }

    public Student_entity GetOneStudent(Long id) {
        return this.student.stream().filter( (Student_entity e) -> e.getID() == id).findFirst().get();
    }


    public void PutStudent(List<Student_entity> student, Long ID) {
        Optional<Student_entity> s = student.stream().filter((Student_entity e) -> e.getID() == ID).findAny();
    }
}
