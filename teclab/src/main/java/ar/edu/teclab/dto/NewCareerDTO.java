package ar.edu.teclab.dto;
import java.util.List;

public class NewCareerDTO {
    private List<Long> teacher;
    private List<Long> matter;

    public List<Long> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<Long> teacher) {
        this.teacher = teacher;
    }

    public List<Long> getMatter() {
        return matter;
    }

    public void setMatter(List<Long> matter) {
        this.matter = matter;
    }
}
