package backend.application.tp_module.controllers;

import backend.application.tp_module.models.TestEntity;
import backend.application.tp_module.services.TestEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestEntityController {

    private final TestEntityService service;

    @PostMapping
    public TestEntity create(@RequestParam String name) {
        return service.save(name);
    }

    @GetMapping
    public List<TestEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/by-name")
    public TestEntity getByName(@RequestParam String name) {
        return service.getByName(name);
    }
}