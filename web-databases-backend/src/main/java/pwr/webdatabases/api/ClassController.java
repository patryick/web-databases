package pwr.webdatabases.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwr.webdatabases.logic.model.ClassTo;
import pwr.webdatabases.logic.service.ClassService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/classes")
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping
    public ResponseEntity<ClassTo> postClass(@RequestBody ClassTo classTo) {
        return ResponseEntity.ok(classService.create(classTo));
    }

    @PutMapping
    public ResponseEntity<ClassTo> putClass(@RequestBody ClassTo classTo) {
        return ResponseEntity.ok(classService.update(classTo));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteClass(@RequestBody ClassTo classTo) {
        classService.delete(classTo);
        return ResponseEntity.noContent().build();
    }
}
