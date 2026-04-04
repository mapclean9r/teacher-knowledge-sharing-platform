package backend.application.tp_module.repositories;

import backend.application.tp_module.models.entities.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    Page<Resource> findByGrade(Integer grade, Pageable pageable);
}