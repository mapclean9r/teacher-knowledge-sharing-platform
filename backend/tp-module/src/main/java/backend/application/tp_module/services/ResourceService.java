package backend.application.tp_module.services;

import backend.application.tp_module.mappers.ResourceMapper;
import backend.application.tp_module.models.dto.CreateResourceRequest;
import backend.application.tp_module.models.dto.ResourceResponse;
import backend.application.tp_module.models.entities.Resource;
import backend.application.tp_module.models.entities.User;
import backend.application.tp_module.repositories.ResourceRepository;
import backend.application.tp_module.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;
    private final UserRepository userRepository;

    public ResourceService(ResourceRepository resourceRepository, UserRepository userRepository) {
        this.resourceRepository = resourceRepository;
        this.userRepository = userRepository;
    }

    public ResourceResponse createResource(CreateResourceRequest dto, Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Resource resource = ResourceMapper.toEntity(dto);
        resource.setCreatedBy(user);

        return ResourceMapper.toResponse(resourceRepository.save(resource));
    }

    public Page<ResourceResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());

        return resourceRepository.findAll(pageable)
                .map(ResourceMapper::toResponse);
    }

    public Page<ResourceResponse> getByGrade(Integer grade, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());

        return resourceRepository.findByGrade(grade, pageable)
                .map(ResourceMapper::toResponse);
    }
}