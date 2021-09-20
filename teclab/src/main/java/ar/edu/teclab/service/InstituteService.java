package ar.edu.teclab.service;

import ar.edu.teclab.dto.InputMatterDTO;
import ar.edu.teclab.dto.InputStudentDTO;
import ar.edu.teclab.dto.InputTeacherDTO;
import ar.edu.teclab.entity.Career_entity;
import ar.edu.teclab.entity.Matter_entity;
import ar.edu.teclab.entity.Student_entity;
import ar.edu.teclab.entity.Teacher_entity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class InstituteService {
    private static CareerService career = new CareerService();
    private static TeacherService teacher = new TeacherService();
    private static MatterService matter = new MatterService();
    private static StudentService student = new StudentService();
    // TEACHER
    public static void AddTeacher(String fullname, Long DNI, String email, String title, Long IDmatter) {
        if(IDmatter == null){
            teacher.NewTeacher(fullname, DNI, email, title, null);
        }
        else {
            Matter_entity Matter = matter.GetOneMatter(IDmatter);
            teacher.NewTeacher(fullname, DNI, email, title, Matter);
        }
    }

    public static void RemoveTeacher(Long IDTeacher) {
        Teacher_entity Teacher = teacher.getOneTeacher(IDTeacher);
        teacher.getTeacher().remove(Teacher);
    }

    public static void PutTeacher(Long IDTeacher, InputTeacherDTO teacherDTO) {
        Teacher_entity Teacher = teacher.getOneTeacher(IDTeacher);

        if(teacherDTO.getFullname() != "" || teacherDTO.getFullname() != null) {
            Teacher.setFullname(teacherDTO.getFullname());
        }

        if(teacherDTO.getEmail() != "" || teacherDTO.getEmail() != null) {
            Teacher.setEmail(teacherDTO.getEmail());
        }

        if(teacherDTO.getId_matter() != null) {
            Teacher.setMatter(matter.GetOneMatter(teacherDTO.getId_matter()));
        }
    }
    public static List<Teacher_entity> GetAllTeacher() {
        return teacher.getTeacher();
    }

    public static Teacher_entity GetOneTeacher(Long id) {
        return teacher.getOneTeacher(id);
    }

    // MATTER
    public static void AddMatter(String name) {
        matter.AddMatter(name);
    }
    public static void RemoveMatter(Long IDMatter) {
        matter.getAllMatter().remove(matter.GetOneMatter(IDMatter));
    }
    public static void PutMatter(Long IDMatter, InputMatterDTO matterDTO) {
        Matter_entity Matter = matter.GetOneMatter(IDMatter);

        if(matterDTO.getName() != "" || matterDTO.getName() != null) {
            Matter.setName(matterDTO.getName());
        }
    }

    public static List<Matter_entity> GetAllMatter() {
        return matter.getAllMatter();
    }
    public static Matter_entity GetOneMatter(Long id) {
        return matter.GetOneMatter(id);
    }

    // STUDENT
    public static void AddStudent(InputStudentDTO inputStudentDTO) {
        student.AddStudent(inputStudentDTO);
    }
    public static void RemoveStudent(Long IDTeacher) {
        Student_entity Student = student.GetOneStudent(IDTeacher);
        student.getAllStudent().remove(Student);
    }

    public static void PutStudent(Long IDStudent, InputStudentDTO studentDTO) {
        Student_entity Student = student.GetOneStudent(IDStudent);

        if(studentDTO.getFullName() != "" || studentDTO.getFullName() != null) {
            Student.setFullname(studentDTO.getFullName());
        }

        if(studentDTO.getEmail() != "" || studentDTO.getEmail() != null) {
            Student.setEmail(studentDTO.getEmail());
        }
    }

    public static List<Student_entity> GetAllStudent() {
        return student.getAllStudent();
    }
    public static Student_entity GetOneStudent(Long id) {
        return student.GetOneStudent(id);
    }

    // CAREER
    public static void AddCareer(List<Long> IDTeacher, List<Long> IDMatter) {
        try{
            List<Teacher_entity> Teacher = new ArrayList<>();
            List<Matter_entity> Matter = new ArrayList<>();
            IDTeacher.stream().map( (e) -> Teacher.add(teacher.getOneTeacher(e)));
            IDMatter.stream().map( (e) -> Matter.add(matter.GetOneMatter(e)));
            career.AddCareer(Teacher, Matter);
        }catch (Exception e) {
            throw e;
        }
    }

    public static void AddStudentToCareer(Long IDCareer, Long IDStudent) {
        try {
            career.AddNewStudent(IDCareer, student.GetOneStudent(IDStudent));
        }catch (Exception e){
            throw e;
        }
    }

    public static void DeleteCareer(Long IDCareer) {
        Career_entity Career = career.GetOneCareer(IDCareer);
        career.GetCareer().remove(Career);
    }

    public static List<Career_entity> GetAllCareer() {
        return career.GetCareer();
    }
    public static Career_entity GetOneCareer(Long id) {
        return career.GetOneCareer(id);
    }
}
