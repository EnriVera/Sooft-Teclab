package ar.edu.teclab.dto;

public class InputStudentDTO {
    private String FullName;
    private Long Dni;
    private String Email;

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public Long getDni() {
        return Dni;
    }

    public void setDni(Long dni) {
        Dni = dni;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
