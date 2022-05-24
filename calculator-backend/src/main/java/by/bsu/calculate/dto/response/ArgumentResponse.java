package by.bsu.calculate.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ArgumentResponse {

    private final String name;
    private final Double count;
}
