package ar.edu.teclab.controller;

import ar.edu.teclab.dto.InputTeacherDTO;
import ar.edu.teclab.service.InstituteService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins = "*")
public class TeacherController {

    private static final Log LOG = LogFactory.getLog(PruebaController.class);

    @PostMapping("/add_teacher")
    public ResponseEntity AddNewMatter(@RequestBody() InputTeacherDTO teacher) {
        try {
            InstituteService.AddTeacher(teacher.getFullname(), teacher.getDni(), teacher.getEmail(), teacher.getTitle(), teacher.getId_matter());
            return ResponseEntity.ok("Todo ok");
        } catch (Exception e) {
            LOG.error("Error", e);
        }
        return null;
    }
    @GetMapping("/get_teacher")
    public ResponseEntity GetTeacher(@Nullable() @RequestParam(value = "id") Long IDTeacher) {
        try {
            return IDTeacher == null ? ResponseEntity.ok(InstituteService.GetAllTeacher()) : ResponseEntity.ok(InstituteService.GetOneTeacher(IDTeacher));
        } catch (Exception e) {
            LOG.error("Error", e);
        }
        return null;
    }

    @DeleteMapping("/delete_teacher")
    public ResponseEntity DeleteTeacher(@RequestParam(value = "id") Long IDTeacher) {
        try {
            InstituteService.RemoveTeacher(IDTeacher);
            return ResponseEntity.ok("El profesor fue eliminado");
        } catch (Exception e) {
            LOG.error("Error", e);
        }
        return null;
    }

    @PutMapping("/put_teacher")
    public ResponseEntity PutTeacher(@RequestParam(value = "id") Long IDTeacher, @RequestBody() InputTeacherDTO inputTeacherDTO) {
        try {
            InstituteService.PutTeacher(IDTeacher, inputTeacherDTO);
            return ResponseEntity.ok("Modificacion completo");
        } catch (Exception e) {
            LOG.error("Error", e);
        }
        return null;
    }
}
