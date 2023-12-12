package pwr.webdatabases.api;

import org.springframework.web.bind.annotation.*;
import pwr.webdatabases.logic.service.ClassService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/classes")
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

}
