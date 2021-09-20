package ar.edu.teclab.entity;

public class Student_entity extends Person_entity {

    private Career_entity career;

    public Student_entity(String fullname, Long DNI, String email) {
        super(fullname, DNI, email);
    }

    public Career_entity getCareer() {
        return career;
    }

    public void setCareer(Career_entity career) {
        this.career = career;
    }

}
