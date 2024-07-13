package com.alura.jarey.foro_hub.Domain.Topics;

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
@Entity(name = "Topic")
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String message;
    private LocalDateTime created;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Tag tag;
    private Long user_id;
    private Long course_id;

    public Topic(DTOTopic dtoTopic){
        this.title = dtoTopic.title();
        this.message = dtoTopic.message();
        this.created = LocalDateTime.now();
        this.status = Status.valueOf("CREADO");
        this.tag = dtoTopic.tag();
        this.user_id = dtoTopic.user_id();
        this.course_id = dtoTopic.course_id();
    }

    public void update(DTOUpdate dtoUpdateTopic) {
        if (dtoUpdateTopic.title() != null) {
            this.title = dtoUpdateTopic.title();
        }
        if (dtoUpdateTopic.message() != null) {
            this.message = dtoUpdateTopic.message();
        }
        if (dtoUpdateTopic.status() != null) {
            this.status = dtoUpdateTopic.status();
        } else if (dtoUpdateTopic.status() == null) {
            this.status = Status.valueOf("ACTUALIZADO");
        }
        if (dtoUpdateTopic.tag() != null) {
            this.tag = dtoUpdateTopic.tag();
        }
    }

    public void delete() {
        this.status = Status.valueOf("ELIMINADO");
    }
}
