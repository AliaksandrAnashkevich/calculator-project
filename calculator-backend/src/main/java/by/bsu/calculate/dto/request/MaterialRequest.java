package by.bsu.calculate.dto.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MaterialRequest {

    private final String name;
    private final String range;
    private final String description;
}
