package com.alura.jarey.foro_hub.Domain.Answer;

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
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private Long topic_id;
    private LocalDateTime created;
    private Long user_id;
    private Boolean solved;
    private Integer score;

    public Answer(DTOAnswer dtoAswer){
        this.message = dtoAswer.message();
        this.topic_id = dtoAswer.topic_id();
        this.created = LocalDateTime.now();
        this.user_id = dtoAswer.user_id();
        this.solved = false;
        this.score = 0;
    }
}
