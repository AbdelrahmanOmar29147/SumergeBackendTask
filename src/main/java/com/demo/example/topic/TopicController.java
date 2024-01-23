package com.demo.example.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    @Qualifier("explicitTopicService")
    private TopicService topicService;

    @GetMapping( "/topics")
    public List<Topic> getAllTopics() {
        System.out.println(topicService.isPlayground);
            return topicService.getAllTopics();
    }

    @GetMapping("/topics/{id}")
    public Topic getTopic(@PathVariable Integer id){
        return topicService.getTopic(id);
    }

    @PostMapping(value = "/topics", consumes = {"application/json"})
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @PutMapping(value = "/topics/{id}", consumes = {"application/json"})
    public void addTopic(@PathVariable String id, @RequestBody Topic topic){
        topicService.updateTopic(topic);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable Integer id){
        topicService.deleteTopic(id);
    }
}
