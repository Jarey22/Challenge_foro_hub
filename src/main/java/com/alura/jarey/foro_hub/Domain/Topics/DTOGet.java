package com.alura.jarey.foro_hub.Domain.Topics;

import java.time.LocalDateTime;

public record DTOGet(
        String title,
        String message,
        LocalDateTime created,
        Status status,
        Long user_id,
        Long course_id
)
    {
    public DTOGet(Topic topic){
        this(
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreated(),
                topic.getStatus(),
                topic.getUser_id(),
                topic.getCourse_id()
        );
    }
}
