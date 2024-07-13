package com.alura.jarey.foro_hub.Domain.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Answer")
@Table(name = "answers")
public class UserCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Long user_id;
    Long course_id;
    LocalDateTime enrolled;
    Boolean active;

    public UserCourse(DTOUserCourse dtoUsersCourses){
        this.user_id = dtoUsersCourses.user_id();
        this.course_id = dtoUsersCourses.course_id();
        this.enrolled = LocalDateTime.now();
        this.active = true;
    }
}
