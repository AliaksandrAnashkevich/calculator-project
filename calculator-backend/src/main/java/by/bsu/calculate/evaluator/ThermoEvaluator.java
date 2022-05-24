package by.bsu.calculate.evaluator;

import by.bsu.calculate.model.Argument;
import by.bsu.calculate.model.Expression;
import by.bsu.calculate.repository.ArgumentRepository;
import by.bsu.calculate.repository.ExpressionRepository;
import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.StaticVariableSet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ThermoEvaluator {

    private final static String TEMPERATURE_SYMBOL = "t";
    private final static String RESISTANCE_SYMBOL = "r";

    private final ArgumentRepository argumentRepository;
    private final ExpressionRepository expressionRepository;


    public Double count(Long materialId, Double temperature, Double resistance) {

        DoubleEvaluator eval = new DoubleEvaluator();

        String expression = getExpression(materialId, temperature);
        List<Argument> arguments = argumentRepository.findByMaterialId(materialId);
        StaticVariableSet<Double> variables = setVariables(arguments, temperature, resistance);

        return eval.evaluate(expression, variables);
    }

    private String getExpression(Long materialId,
                                 Double temperature) {

        Expression expression = expressionRepository
                .findByMaterialIdAndMaxTemperatureGreaterThanEqualAndMinTemperatureLessThanEqual(materialId,
                        temperature, temperature)
                .stream()
                .findFirst()
                .orElseThrow();

        return expression.getName();
    }

    private StaticVariableSet<Double> setVariables(List<Argument> arguments, Double temperature, Double resistance) {
        StaticVariableSet<Double> variables = new StaticVariableSet<>();
        arguments.forEach(argument -> variables.set(argument.getName(), argument.getCount()));

        variables.set(TEMPERATURE_SYMBOL, temperature);
        variables.set(RESISTANCE_SYMBOL, resistance);

        return variables;
    }

}
