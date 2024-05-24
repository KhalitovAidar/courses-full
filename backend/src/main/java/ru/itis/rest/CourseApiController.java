package ru.itis.rest;

import ru.itis.api.CourseApiService;
import ru.itis.dto.CategorySecondDTO;
import ru.itis.dto.CourseResponseDTO;
import ru.itis.dto.RequestFindDTO;
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
