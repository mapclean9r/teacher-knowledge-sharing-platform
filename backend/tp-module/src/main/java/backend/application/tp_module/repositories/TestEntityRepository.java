package backend.application.tp_module.repositories;


import backend.application.tp_module.models.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestEntityRepository extends JpaRepository<TestEntity, Long> {
    TestEntity findByName(String name);
}