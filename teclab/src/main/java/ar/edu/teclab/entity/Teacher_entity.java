package ar.edu.teclab.entity;

public class Teacher_entity extends Person_entity {
    private String title = "";

    private Matter_entity matter = null;
    public Teacher_entity(String fullname, Long DNI, String email, String title) {
        super(fullname, DNI, email);

        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Matter_entity getMatter() {
        return matter;
    }

    public void setMatter(Matter_entity matter) {
        this.matter = matter;
    }
}
