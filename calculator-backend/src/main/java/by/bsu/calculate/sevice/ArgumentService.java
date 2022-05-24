package by.bsu.calculate.sevice;

import by.bsu.calculate.dto.request.ArgumentRequest;
import by.bsu.calculate.dto.response.ArgumentResponse;
import by.bsu.calculate.mapper.ArgumentMapper;
import by.bsu.calculate.model.Argument;
import by.bsu.calculate.repository.ArgumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArgumentService {

    private final ArgumentMapper argumentMapper;
    private final ArgumentRepository argumentRepository;

    public ArgumentResponse getById(Long id) {

        Argument argument = argumentRepository.findById(id)
                .orElseThrow();

        return argumentMapper.toDto(argument);
    }

    public List<ArgumentResponse> getAll() {
        List<Argument> arguments = argumentRepository.findAll();

        return arguments.stream()
                .map(argumentMapper::toDto)
                .collect(Collectors.toList());
    }

    public ArgumentResponse create(ArgumentRequest argumentRequest){
        Argument argument = argumentMapper.toEntity(argumentRequest);
        Argument savedArgument = argumentRepository.save(argument);

        return argumentMapper.toDto(savedArgument);
    }

    public ArgumentResponse update(Long id, ArgumentRequest argumentRequest){
        Argument argument = argumentMapper.updateRequestToEntity(argumentRequest,
                argumentRepository.getById(id));

        Argument updatedArgument = argumentRepository.save(argument);

        return argumentMapper.toDto(updatedArgument);
    }

    public void delete(Long id){
        Argument argument = argumentRepository.findById(id)
                .orElseThrow();

        argumentRepository.delete(argument);
    }
}
