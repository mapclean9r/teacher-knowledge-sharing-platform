package backend.application.tp_module.mappers;

import backend.application.tp_module.models.dto.CreateResourceRequest;
import backend.application.tp_module.models.dto.FileResponse;
import backend.application.tp_module.models.dto.ResourceResponse;
import backend.application.tp_module.models.entities.Resource;

public class ResourceMapper {

    public static Resource toEntity(CreateResourceRequest dto) {
        Resource r = new Resource();
        r.setTitle(dto.title);
        r.setDescription(dto.description);
        r.setGrade(dto.grade);
        r.setSubject(dto.subject);
        return r;
    }

    public static ResourceResponse toResponse(Resource r) {
        ResourceResponse res = new ResourceResponse();
        res.id = r.getId();
        res.title = r.getTitle();
        res.description = r.getDescription();
        res.grade = r.getGrade();
        res.subject = r.getSubject();
        res.createdByName = r.getCreatedBy().getFullName();

        if (r.getFiles() != null) {
            res.files = r.getFiles().stream().map(file -> {
                FileResponse f = new FileResponse();
                f.id = file.getId();
                f.fileName = file.getFileName();
                f.fileType = file.getFileType();
                f.fileUrl = file.getFileUrl();
                return f;
            }).toList();
        }

        return res;
    }
}