package ru.itis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.itis.api.CourseApiService;
import ru.itis.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
@Tag(name = "Курсы")
public class CourseApiController {

    private final CourseApiService courseApiService;

    @PostMapping("/secondCourses")
    @Operation(summary = "Получить вторую категорию курсов")
    public List<CategorySecondDTO> getSecondCoursesByFirstCourse(@RequestBody RequestFindDTO requestFindDTO) throws Exception {
        return courseApiService.getSecondCoursesByFirstCourse(requestFindDTO);
    }

    @GetMapping("/course/{alias}")
    @Operation(summary = "Получить описание по курсу")
    public CourseResponseDTO getItemsByAlias(@PathVariable String alias) throws Exception {
        return courseApiService.getCourseByAlias(alias);
    }

    @PostMapping("/product")
    @Operation(summary = "Получить продукты курса")
    public List<ProductResponseFront> getProductsByCategoryAndLimit(@RequestBody ProductFindRequest request) throws JsonProcessingException {
        return courseApiService.findProducts(request);
    }
}
