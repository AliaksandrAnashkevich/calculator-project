package by.bsu.calculate.controller;

import by.bsu.calculate.dto.request.ExpressionRequest;
import by.bsu.calculate.dto.response.ExpressionResponse;
import by.bsu.calculate.sevice.ExpressionsService;
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
@RequestMapping("/expression")
@Tag(name = "expression")
@RequiredArgsConstructor
public class ExpressionController {

    private final ExpressionsService expressionsService;

    @Operation(summary = "Get expressions", description = "Get all expressions")
    @ApiResponse(responseCode = "200", description = "Success",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExpressionResponse.class)))
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    @GetMapping
    public List<ExpressionResponse> getAll(){
        return expressionsService.getAll();
    }

    @Operation(summary = "Get expression", description = "Get expression by id")
    @ApiResponse(responseCode = "200", description = "Success",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExpressionResponse.class)))
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    @GetMapping("{id}")
    public ExpressionResponse fetById(@PathVariable Long id){
        return expressionsService.getById(id);
    }

    @Operation(summary = "Create expression", description = "Create new expression")
    @ApiResponse(responseCode = "200", description = "Success",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExpressionResponse.class)))
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    @ApiResponse(responseCode = "409", description = "Conflict", content = @Content)
    @PostMapping
    public ExpressionResponse create(@RequestBody ExpressionRequest expressionRequest) {
        return expressionsService.create(expressionRequest);
    }

    @Operation(summary = "Update expression", description = "Update expression by id")
    @ApiResponse(responseCode = "200", description = "Success",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExpressionResponse.class)))
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    @ApiResponse(responseCode = "409", description = "Conflict", content = @Content)
    @PutMapping("{id}")
    public ExpressionResponse update(@PathVariable Long id, @RequestBody ExpressionRequest expressionRequest) {
        return expressionsService.update(id, expressionRequest);
    }

    @Operation(summary = "Delete expression", description = "Delete expression by id")
    @ApiResponse(responseCode = "200", description = "Success",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExpressionResponse.class)))
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        expressionsService.delete(id);
    }
}
