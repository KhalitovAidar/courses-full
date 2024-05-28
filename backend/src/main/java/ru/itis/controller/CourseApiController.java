package ru.itis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.itis.api.CourseApiService;
import ru.itis.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseApiController {

    private final CourseApiService courseApiService;

    @PostMapping("/secondCourses")
    public List<CategorySecondDTO> getSecondCoursesByFirstCourse(@RequestBody RequestFindDTO requestFindDTO) throws Exception {
        return courseApiService.getSecondCoursesByFirstCourse(requestFindDTO);
    }

    @GetMapping("/course/{alias}")
    public CourseResponseDTO getItemsByAlias(@PathVariable String alias) throws Exception {
        return courseApiService.getCourseByAlias(alias);
    }

    @PostMapping("/product")
    public List<ProductResponseFront> getProductsByCategoryAndLimit(@RequestBody ProductFindRequest request) throws JsonProcessingException {
        List<ProductResponseFront> productResponseFronts = courseApiService.findProducts(request);
        return courseApiService.findProducts(request);
    }
}
