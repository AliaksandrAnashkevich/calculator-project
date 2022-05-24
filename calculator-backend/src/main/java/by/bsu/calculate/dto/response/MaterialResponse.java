package by.bsu.calculate.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MaterialResponse {

    private final Long id;
    private final String name;
    private final String range;
    private final String description;
}
