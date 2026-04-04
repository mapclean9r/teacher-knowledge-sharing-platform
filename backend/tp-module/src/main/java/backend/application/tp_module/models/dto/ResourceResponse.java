package backend.application.tp_module.models.dto;

import java.util.List;

public class ResourceResponse {
    public Integer id;
    public String title;
    public String description;
    public Integer grade;
    public String subject;
    public String createdByName;
    public List<FileResponse> files;
}
