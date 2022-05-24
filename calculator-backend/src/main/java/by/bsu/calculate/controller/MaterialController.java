package by.bsu.calculate.controller;

import by.bsu.calculate.dto.request.MaterialRequest;
import by.bsu.calculate.dto.response.MaterialResponse;
import by.bsu.calculate.sevice.MaterialService;
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
@RequestMapping("/material")
@Tag(name = "material")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService expressionsService;

    @Operation(summary = "Get materials", description = "Get all materials")
    @ApiResponse(responseCode = "200", description = "Success",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MaterialResponse.class)))
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    @GetMapping
    public List<MaterialResponse> getAll(){
        return expressionsService.getAll();
    }

    @Operation(summary = "Get material", description = "Get material by id")
    @ApiResponse(responseCode = "200", description = "Success",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MaterialResponse.class)))
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    @GetMapping("{id}")
    public MaterialResponse fetById(@PathVariable Long id){
        return expressionsService.getById(id);
    }

    @Operation(summary = "Create material", description = "Create new material")
    @ApiResponse(responseCode = "200", description = "Success",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MaterialResponse.class)))
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    @ApiResponse(responseCode = "409", description = "Conflict", content = @Content)
    @PostMapping
    public MaterialResponse create(@RequestBody MaterialRequest materialRequest) {
        return expressionsService.create(materialRequest);
    }

    @Operation(summary = "Update material", description = "Update material by id")
    @ApiResponse(responseCode = "200", description = "Success",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MaterialResponse.class)))
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    @ApiResponse(responseCode = "409", description = "Conflict", content = @Content)
    @PutMapping("{id}")
    public MaterialResponse update(@PathVariable Long id, @RequestBody MaterialRequest expressionRequest) {
        return expressionsService.update(id, expressionRequest);
    }

    @Operation(summary = "Delete material", description = "Delete material by id")
    @ApiResponse(responseCode = "200", description = "Success",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MaterialResponse.class)))
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        expressionsService.delete(id);
    }
}
