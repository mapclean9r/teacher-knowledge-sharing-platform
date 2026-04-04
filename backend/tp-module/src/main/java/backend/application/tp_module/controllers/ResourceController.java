package backend.application.tp_module.controllers;

import backend.application.tp_module.models.dto.CreateResourceRequest;
import backend.application.tp_module.models.dto.ResourceResponse;
import backend.application.tp_module.services.ResourceService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/resources")
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @PostMapping
    public ResponseEntity<ResourceResponse> create(
            @RequestBody CreateResourceRequest request,
            @RequestParam Integer userId) {
        return ResponseEntity.ok(resourceService.createResource(request, userId));
    }

    @GetMapping
    public Page<ResourceResponse> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return resourceService.getAll(page, size);
    }

    @GetMapping("/grade/{grade}")
    public Page<ResourceResponse> getByGrade(
            @PathVariable Integer grade,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return resourceService.getByGrade(grade, page, size);
    }
}