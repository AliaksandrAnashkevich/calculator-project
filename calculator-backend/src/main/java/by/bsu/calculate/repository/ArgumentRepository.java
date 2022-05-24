package by.bsu.calculate.repository;

import by.bsu.calculate.model.Argument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArgumentRepository extends JpaRepository<Argument, Long> {

    List<Argument> findByMaterialId(Long materialId);
}
