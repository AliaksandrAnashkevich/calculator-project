package by.bsu.calculate.controller;

import by.bsu.calculate.dto.response.MaterialResponse;
import by.bsu.calculate.evaluator.ThermoEvaluator;
import by.bsu.calculate.sevice.MaterialService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/calculate")
@Tag(name = "calculate")
@RequiredArgsConstructor
public class CalculateController {

    private final ThermoEvaluator thermoEvaluator;
    private final MaterialService materialService;

    @GetMapping
    public List<MaterialResponse> findAll(){
        return materialService.getAll();
    }

    @GetMapping(value = "/count",params = {"id", "t", "r"})
    public String count(
            @RequestParam() Long id,
            @RequestParam() Double t,
            @RequestParam() Double r
    ) {
        return thermoEvaluator.count(id, t, r).toString();
    }
}
