package ar.edu.teclab.controller;

import ar.edu.teclab.dto.InputMatterDTO;
import ar.edu.teclab.service.InstituteService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matter")
@CrossOrigin(origins = "*")
public class MatterController {
    private static final Log LOG = LogFactory.getLog(PruebaController.class);


    @PostMapping("/add_matter")
    public ResponseEntity AddNewMatter(@RequestBody() InputMatterDTO matter) {
        try {
            InstituteService.AddMatter(matter.getName());
            return ResponseEntity.ok("Todo ok");
        } catch (Exception e) {
            LOG.error("Error", e);
        }
        return null;
    }
    @GetMapping("/get_matter")
    public ResponseEntity GetStudent(@Nullable() @RequestParam(value = "id") Long IDMatter) {
        try {
            return IDMatter == null ? ResponseEntity.ok(InstituteService.GetAllMatter()) : ResponseEntity.ok(InstituteService.GetOneMatter(IDMatter));
        } catch (Exception e) {
            LOG.error("Error", e);
        }
        return null;
    }

    @DeleteMapping("/delete_matter")
    public ResponseEntity DeleteMatter(@RequestParam(value = "id") Long IDMatter) {
        try {
            InstituteService.RemoveMatter(IDMatter);
            return ResponseEntity.ok("El matter fue eliminado");
        } catch (Exception e) {
            LOG.error("Error", e);
        }
        return null;
    }

    @PutMapping("/put_matter")
    public ResponseEntity PutMatter(@RequestParam(value = "id") Long IDMatter, @RequestBody() InputMatterDTO inputMatterDTO) {
        try {
            InstituteService.PutMatter(IDMatter, inputMatterDTO);
            return ResponseEntity.ok("Modificacion completo");
        } catch (Exception e) {
            LOG.error("Error", e);
        }
        return null;
    }
}
