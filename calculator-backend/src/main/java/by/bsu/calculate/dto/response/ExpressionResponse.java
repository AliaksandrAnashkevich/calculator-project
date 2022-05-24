package by.bsu.calculate.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ExpressionResponse {

    private final String name;
    private final Double minTemperature;
    private final String maxTemperature;
}
