package ar.edu.teclab.controller;

import ar.edu.teclab.dto.NewCareerDTO;
import ar.edu.teclab.dto.StudentCareerDTO;
import ar.edu.teclab.service.InstituteService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/career")
@CrossOrigin(origins = "*")
public class CareerController {
    private static final Log LOG = LogFactory.getLog(PruebaController.class);

    @PostMapping("/add_career")
    public ResponseEntity AddNewCareer(@RequestBody() NewCareerDTO careerDTO) {
        try {
            InstituteService.AddCareer(careerDTO.getTeacher(), careerDTO.getMatter());
            return ResponseEntity.ok("Todo ok");
        } catch (Exception e) {
            LOG.error("Error", e);
        }
        return null;
    }
    @PostMapping("/add_student_career")
    public ResponseEntity AddStudentCareer(@RequestBody() StudentCareerDTO studentCareerDTO) {
        try {
            InstituteService.AddStudentToCareer(studentCareerDTO.getIDCareer(), studentCareerDTO.getIDStudent());
            return ResponseEntity.ok("crate student to career");
        } catch (Exception e) {
            LOG.error("Error", e);
        }
        return null;
    }

    @GetMapping("/get_career")
    public ResponseEntity GetCareer(@Nullable() @RequestParam(value = "id") Long IDCareer) {
        try {
            return IDCareer == null ? ResponseEntity.ok(InstituteService.GetAllCareer()) : ResponseEntity.ok(InstituteService.GetOneCareer(IDCareer));
        } catch (Exception e) {
            LOG.error("Error", e);
        }
        return null;
    }

    @DeleteMapping("/delete_career")
    public ResponseEntity DeleteCareer(@RequestParam(value = "id") Long IDCareer) {
        try {
            InstituteService.DeleteCareer(IDCareer);
            return ResponseEntity.ok("La carrera fue eliminada");
        } catch (Exception e) {
            LOG.error("Error", e);
        }
        return null;
    }
}
