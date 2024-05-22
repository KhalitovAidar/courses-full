package com.agona.security.rest;

import com.agona.security.api.CourseApiService;
import com.agona.security.dto.CategorySecondDTO;
import com.agona.security.dto.CourseResponseDTO;
import com.agona.security.dto.RequestFindDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseApiController {

    private final CourseApiService courseApiService;

    @GetMapping("/secondCourses")
    public List<CategorySecondDTO> getSecondCoursesByFirstCourse(@RequestBody RequestFindDTO requestFindDTO) throws Exception {
        return courseApiService.getSecondCoursesByFirstCourse(requestFindDTO);
    }

    @GetMapping("/course/{alias}")
    public CourseResponseDTO getItemsByAlias(@PathVariable String alias) throws Exception {
        System.out.println(alias);
        return courseApiService.getCourseByAlias(alias);
    }
}
