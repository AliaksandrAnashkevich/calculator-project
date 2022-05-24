package by.bsu.calculate.mapper;

import by.bsu.calculate.dto.request.ArgumentRequest;
import by.bsu.calculate.dto.response.ArgumentResponse;
import by.bsu.calculate.model.Argument;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ArgumentMapper {

    ArgumentResponse toDto(Argument argument);

    Argument toEntity(ArgumentRequest argumentRequest);

    Argument updateRequestToEntity(ArgumentRequest argumentRequest, @MappingTarget Argument argument);
}
