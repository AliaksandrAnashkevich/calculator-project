package by.bsu.calculate.sevice;

import by.bsu.calculate.dto.request.MaterialRequest;
import by.bsu.calculate.dto.response.MaterialResponse;
import by.bsu.calculate.mapper.MaterialMapper;
import by.bsu.calculate.model.Material;
import by.bsu.calculate.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MaterialService {

    private final MaterialMapper materialMapper;
    private final MaterialRepository materialRepository;

    public MaterialResponse getById(Long id) {

        Material material = materialRepository.findById(id)
                .orElseThrow();

        return materialMapper.toDto(material);
    }

    public List<MaterialResponse> getAll() {

        List<Material> materials = materialRepository.findAll();

        return materials.stream()
                .map(materialMapper::toDto)
                .collect(Collectors.toList());
    }

    public MaterialResponse create(MaterialRequest materialRequest) {
        Material material = materialMapper.toEntity(materialRequest);
        Material savedMaterial = materialRepository.save(material);

        return materialMapper.toDto(savedMaterial);
    }

    public MaterialResponse update(Long id, MaterialRequest materialRequest) {
        Material material = materialMapper.updateRequestToEntity(materialRequest,
                materialRepository.getById(id));

        Material updateMaterial = materialRepository.save(material);

        return materialMapper.toDto(updateMaterial);
    }

    public void delete(Long id) {
        Material material = materialRepository.findById(id)
                .orElseThrow();

        materialRepository.delete(material);
    }
}
