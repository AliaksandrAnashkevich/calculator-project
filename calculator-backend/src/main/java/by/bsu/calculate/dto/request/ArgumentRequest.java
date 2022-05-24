package by.bsu.calculate.dto.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ArgumentRequest {

    private final String name;
    private final Double count;
}
