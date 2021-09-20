package ar.edu.teclab.controller;

import ar.edu.teclab.dto.InputStudentDTO;
import ar.edu.teclab.service.InstituteService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class StudentController {

    private static final Log LOG = LogFactory.getLog(PruebaController.class);

    @PostMapping("/add_student")
    public ResponseEntity AddNewStudent(@RequestBody() InputStudentDTO student) {
        try {
            InstituteService.AddStudent(student);
            return ResponseEntity.ok("Todo ok");
        } catch (Exception e) {
            LOG.error("Error", e);
        }
        return null;
    }
    @GetMapping("/get_student")
    public ResponseEntity GetStudent(@Nullable() @RequestParam(value = "id") Long IDStudent) {
        try {
            return IDStudent == null ? ResponseEntity.ok(InstituteService.GetAllStudent()) : ResponseEntity.ok(InstituteService.GetOneStudent(IDStudent));
        } catch (Exception e) {
            LOG.error("Error", e);
        }
        return null;
    }

    @DeleteMapping("/delete_student")
    public ResponseEntity DeleteStudent(@RequestParam(value = "id") Long IDStudent) {
        try {
            InstituteService.RemoveStudent(IDStudent);
            return ResponseEntity.ok("El student fue eliminado");
        } catch (Exception e) {
            LOG.error("Error", e);
        }
        return null;
    }

    @PutMapping("/put_student")
    public ResponseEntity PutStudent(@RequestParam(value = "id") Long IDStudent, @RequestBody() InputStudentDTO inputStudentDTO) {
        try {
            InstituteService.PutStudent(IDStudent, inputStudentDTO);
            return ResponseEntity.ok("Modificacion completo");
        } catch (Exception e) {
            LOG.error("Error", e);
        }
        return null;
    }

}
