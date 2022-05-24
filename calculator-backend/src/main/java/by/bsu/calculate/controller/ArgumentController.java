package by.bsu.calculate.controller;

import by.bsu.calculate.dto.request.ArgumentRequest;
import by.bsu.calculate.dto.response.ArgumentResponse;
import by.bsu.calculate.sevice.ArgumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/argument")
@Tag(name = "argument")
@RequiredArgsConstructor
public class ArgumentController {

    private final ArgumentService argumentService;

    @Operation(summary = "Get argument", description = "Get all arguments")
    @ApiResponse(responseCode = "200", description = "Success",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ArgumentResponse.class)))
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    @GetMapping
    public List<ArgumentResponse> getAll(){
        return argumentService.getAll();
    }

    @Operation(summary = "Get argument", description = "Get argument by id")
    @ApiResponse(responseCode = "200", description = "Success",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ArgumentResponse.class)))
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    @GetMapping("{id}")
    public ArgumentResponse fetById(@PathVariable Long id){
        return argumentService.getById(id);
    }

    @Operation(summary = "Create argument", description = "Create new argument")
    @ApiResponse(responseCode = "200", description = "Success",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ArgumentResponse.class)))
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    @ApiResponse(responseCode = "409", description = "Conflict", content = @Content)
    @PostMapping
    public ArgumentResponse create(@RequestBody ArgumentRequest argumentRequest) {
        return argumentService.create(argumentRequest);
    }

    @Operation(summary = "Update argument", description = "Update argument by id")
    @ApiResponse(responseCode = "200", description = "Success",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ArgumentResponse.class)))
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    @ApiResponse(responseCode = "409", description = "Conflict", content = @Content)
    @PutMapping("{id}")
    public ArgumentResponse update(@PathVariable Long id, @RequestBody ArgumentRequest argumentRequest) {
        return argumentService.update(id, argumentRequest);
    }

    @Operation(summary = "Delete argument", description = "Delete argument by id")
    @ApiResponse(responseCode = "200", description = "Success",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ArgumentResponse.class)))
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        argumentService.delete(id);
    }
}
