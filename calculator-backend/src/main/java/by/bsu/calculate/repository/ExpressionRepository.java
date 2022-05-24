package by.bsu.calculate.repository;

import by.bsu.calculate.model.Expression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpressionRepository extends JpaRepository<Expression, Long> {

        List<Expression> findByMaterialIdAndMaxTemperatureGreaterThanEqualAndMinTemperatureLessThanEqual(
                Long materialId,
                Double maxTemperatureLessThan,
                Double minTemperatureGreatThan);
}
