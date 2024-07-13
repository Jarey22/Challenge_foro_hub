package com.alura.jarey.foro_hub.Controller;

import com.alura.jarey.foro_hub.Domain.User.*;
import com.alura.jarey.foro_hub.Domain.User.Profile.DTOProfile;
import com.alura.jarey.foro_hub.Domain.User.Profile.IProfileRepo;
import com.alura.jarey.foro_hub.Domain.User.Profile.UProfile;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private IUserRepo userRepository;

    @Autowired
    private IUserCourse userCourseRepository;

    @Autowired
    private IProfileRepo profileRepository;

    @PostMapping
    @Transactional
    public void createUser(@RequestBody @Valid DTOUser dtoUser){
        userRepository.save(new User(dtoUser));
    }

    @PostMapping("/courses")
    @Transactional
    public void enrollUser(@RequestBody @Valid DTOUserCourse dtoUsersCourses){
        userCourseRepository.save(new UserCourse(dtoUsersCourses));
    }

    @PostMapping("/profiles")
    @Transactional
    public void addUserProfile(@RequestBody @Valid DTOProfile dtoProfiles){
        profileRepository.save(new UProfile(dtoProfiles));
    }

}
