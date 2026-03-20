package backend.application.tp_module.services;

import backend.application.tp_module.models.TestEntity;
import backend.application.tp_module.repositories.TestEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestEntityService {

    private final TestEntityRepository repository;

    public TestEntity save(String name) {
        TestEntity entity = new TestEntity();
        entity.setName(name);
        return repository.save(entity);
    }

    public List<TestEntity> getAll() {
        return repository.findAll();
    }

    public TestEntity getByName(String name) {
        return repository.findByName(name);
    }
}