package by.bsu.calculate.mapper;

import by.bsu.calculate.dto.request.MaterialRequest;
import by.bsu.calculate.dto.response.MaterialResponse;
import by.bsu.calculate.model.Material;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MaterialMapper {

    MaterialResponse toDto(Material material);

    Material toEntity(MaterialRequest materialRequest);

    Material updateRequestToEntity(MaterialRequest materialRequest, @MappingTarget Material material);

}
