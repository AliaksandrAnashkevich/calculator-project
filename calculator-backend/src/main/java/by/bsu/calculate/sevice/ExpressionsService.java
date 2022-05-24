package by.bsu.calculate.sevice;

import by.bsu.calculate.dto.request.ExpressionRequest;
import by.bsu.calculate.dto.response.ExpressionResponse;
import by.bsu.calculate.mapper.ExpressionMapper;
import by.bsu.calculate.model.Expression;
import by.bsu.calculate.repository.ExpressionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpressionsService {

    private final ExpressionMapper expressionMapper;
    private final ExpressionRepository expressionRepository;

    public ExpressionResponse getById(Long id) {

        Expression expression = expressionRepository.findById(id)
                .orElseThrow();

        return expressionMapper.toDto(expression);
    }


    public List<ExpressionResponse> getAll() {
        List<Expression> expressions = expressionRepository.findAll();

        return expressions.stream()
                .map(expressionMapper::toDto)
                .collect(Collectors.toList());
    }

    public ExpressionResponse create(ExpressionRequest expressionRequest) {
        Expression expression = expressionMapper.toEntity(expressionRequest);
        Expression savedExpression = expressionRepository.save(expression);

        return expressionMapper.toDto(savedExpression);
    }

    public ExpressionResponse update(Long id, ExpressionRequest expressionRequest) {
        Expression expression = expressionMapper.updateRequestToEntity(expressionRequest,
                expressionRepository.getById(id));

        Expression updatedExpression = expressionRepository.save(expression);

        return expressionMapper.toDto(updatedExpression);
    }

    public void delete(Long id) {
        Expression expression = expressionRepository.findById(id)
                .orElseThrow();

        expressionRepository.delete(expression);
    }
}
