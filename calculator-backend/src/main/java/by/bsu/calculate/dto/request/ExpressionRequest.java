package by.bsu.calculate.dto.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ExpressionRequest {

    private final String name;
    private final Double minTemperature;
    private final String maxTemperature;
}
