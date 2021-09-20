package ar.edu.teclab.dto;

public class InputTeacherDTO {
    private String fullname;
    private Long dni;
    private String email;
    private String title;
    private Long id_matter;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId_matter() {
        return id_matter;
    }

    public void setId_matter(Long id_matter) {
        this.id_matter = id_matter;
    }
}
