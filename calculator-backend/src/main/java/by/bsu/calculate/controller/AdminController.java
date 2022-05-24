package by.bsu.calculate.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@Tag(name = "admin")
public class AdminController {

    @GetMapping
    public String helloAdmin() {
        return "Hello admin";
    }
}
