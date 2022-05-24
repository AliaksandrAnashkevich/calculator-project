package by.bsu.calculate.mapper;

import by.bsu.calculate.dto.request.ExpressionRequest;
import by.bsu.calculate.dto.response.ExpressionResponse;
import by.bsu.calculate.model.Expression;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ExpressionMapper {

    ExpressionResponse toDto(Expression expression);

    Expression toEntity(ExpressionRequest expressionRequest);

    Expression updateRequestToEntity(ExpressionRequest expressionRequest, @MappingTarget Expression expression);
}
