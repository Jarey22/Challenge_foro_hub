package com.alura.jarey.foro_hub.Controller;

import com.alura.jarey.foro_hub.Domain.Course.Course;
import com.alura.jarey.foro_hub.Domain.Course.DTOCourse;
import com.alura.jarey.foro_hub.Domain.Course.ICourse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("courses")
public class CourseController {

    @Autowired
    private ICourse courseRepository;

    @PostMapping
    @Transactional
    public void createCourse(@RequestBody @Valid DTOCourse dtoCourse){courseRepository.save(new Course(dtoCourse));
        }
}
