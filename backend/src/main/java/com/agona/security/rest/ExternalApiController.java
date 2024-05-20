package com.agona.security.rest;

import com.agona.security.api.CourseApiService;
import com.agona.security.dto.CategorySecondDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ExternalApiController {

    private final CourseApiService courseApiService;

    @GetMapping("/get-external-data")
    public List<CategorySecondDTO> getExternalData(@RequestParam int firstCategory) throws Exception {
        return courseApiService.getSecondCoursesByFirstCourse(firstCategory);
    }
}
