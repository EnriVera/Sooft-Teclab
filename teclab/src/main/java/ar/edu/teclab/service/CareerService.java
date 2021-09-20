package ar.edu.teclab.service;

import ar.edu.teclab.entity.Career_entity;
import ar.edu.teclab.entity.Matter_entity;
import ar.edu.teclab.entity.Student_entity;
import ar.edu.teclab.entity.Teacher_entity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CareerService {
    private List<Career_entity> career = new ArrayList<Career_entity>();

    public void AddCareer(List<Teacher_entity> teacher, List<Matter_entity> matter) {
        this.career.add(new Career_entity(teacher, matter));
    }

    public void AddNewStudent(Long IDCareer, Student_entity student) {
        Optional<Career_entity> career = this.career.stream().filter( (Career_entity e) -> e.getID_Career() == IDCareer).findFirst();
        student.setCareer(career.get());
        career.get().setStudent(student);

    }

    public List<Career_entity> GetCareer() {
        return this.career;
    }
    public Career_entity GetOneCareer(Long id) {
        return this.career.stream().filter( (Career_entity e) -> e.getID_Career() == id).findFirst().get();
    }
}
