package ar.edu.teclab.entity;

import java.util.List;

public class Career_entity {
    private Long ID_Career;
    private List<Teacher_entity> teacher;
    private List<Matter_entity> matter;
    private List<Student_entity> student;

    public Career_entity(List<Teacher_entity> teacher, List<Matter_entity> matter) {
        this.teacher = teacher;
        this.matter = matter;

        this.ID_Career = (long)(Math.random() * 10000);
    }

    public Long getID_Career() {
        return ID_Career;
    }

    public List<Teacher_entity> getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher_entity teacher) {
        this.teacher.add(teacher);
    }

    public List<Matter_entity> getMatter() {
        return matter;
    }

    public void setMatter(Matter_entity matter) {
        this.matter.add(matter);
    }

    public List<Student_entity> getStudent() {
        return student;
    }

    public void setStudent(Student_entity student) {
        this.student.add(student);
    }
}
