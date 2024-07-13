package com.alura.jarey.foro_hub.Controller;

import com.alura.jarey.foro_hub.Domain.Answer.Answer;
import com.alura.jarey.foro_hub.Domain.Answer.DTOAnswer;
import com.alura.jarey.foro_hub.Domain.Answer.IAnswer;
import com.alura.jarey.foro_hub.Domain.Topics.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("topics")
public class TopicController {

    @Autowired
    private ITopicRepo topicRepository;

    @Autowired
    private IAnswer answerRepository;

    @PostMapping
    @Transactional
    public void createTopic(@RequestBody @Valid DTOTopic dtoTopic){
            topicRepository.save(new Topic(dtoTopic));
        }

    @PostMapping("/answers")
    @Transactional
    public void createAnswer(@RequestBody @Valid DTOAnswer dtoAnswer){answerRepository.save(new Answer(dtoAnswer));
        }

        @GetMapping("/{id}")
        public ResponseEntity<DTOGet> listTopic(@PathVariable Long id) {
            Topic topic = topicRepository.getReferenceById(id);
            var topicData = new DTOGet(topic.getTitle(),
                    topic.getMessage(),
                    topic.getCreated(),
                    topic.getStatus(),
                    topic.getUser_id(),
                    topic.getCourse_id());
            return ResponseEntity.ok(topicData);
        }

    @GetMapping
    public ResponseEntity<Page<DTOGet>> listTopics(@PageableDefault(size = 10) Pageable pagination) {
        return ResponseEntity.ok(topicRepository.findAll(pagination).map(DTOGet::new));
    }

        @PutMapping
        @Transactional
        public ResponseEntity updateTopic(@RequestBody @Valid DTOUpdate dtoUpdateTopic) {
            Topic topic = topicRepository.getReferenceById(dtoUpdateTopic.id());
            topic.update(dtoUpdateTopic);
            var topicData = new DTOGet(topic.getTitle(),
                    topic.getMessage(),
                    topic.getCreated(),
                    topic.getStatus(),
                    topic.getUser_id(),
                    topic.getCourse_id());
            return ResponseEntity.ok(topicData);
        }

        @DeleteMapping("/{id}")
        @Transactional
        public ResponseEntity deleteTopic(@PathVariable Long id) {
            Topic topic = topicRepository.getReferenceById(id);
            topic.delete();
            return ResponseEntity.noContent().build();
    }
}
