package ar.edu.teclab.entity;

public class Person_entity {
    private String fullname;
    private Long DNI;
    private String email;
    private Long ID;

    public Person_entity(String fullname, Long DNI, String email) {
        this.fullname = fullname;
        this.DNI = DNI;
        this.email = email;

        this.ID= (long)(Math.random() * 10000);
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Long getDNI() {
        return DNI;
    }

    public void setDNI(Long DNI) {
        this.DNI = DNI;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID_student) {
        this.ID = ID_student;
    }
}
