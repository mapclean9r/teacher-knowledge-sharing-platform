package backend.application.tp_module.controllers;

import backend.application.tp_module.models.entities.FileEntity;
import backend.application.tp_module.models.entities.Resource;
import backend.application.tp_module.repositories.FileRepository;
import backend.application.tp_module.repositories.ResourceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/files")
public class FileController {

    private final FileRepository fileRepository;
    private final ResourceRepository resourceRepository;

    public FileController(FileRepository fileRepository, ResourceRepository resourceRepository) {
        this.fileRepository = fileRepository;
        this.resourceRepository = resourceRepository;
    }

    @PostMapping("/{resourceId}")
    public ResponseEntity<FileEntity> uploadFile(
            @PathVariable Long resourceId,
            @RequestParam("file") MultipartFile file) throws IOException {

        Resource resource = resourceRepository.findById(resourceId)
                .orElseThrow(() -> new RuntimeException("Resource not found"));

        String filePath = "uploads/" + file.getOriginalFilename();
        Files.copy(file.getInputStream(), Paths.get(filePath));

        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(file.getOriginalFilename());
        fileEntity.setFileType(file.getContentType());
        fileEntity.setFileUrl(filePath);
        fileEntity.setResource(resource);

        return ResponseEntity.ok(fileRepository.save(fileEntity));
    }
}
