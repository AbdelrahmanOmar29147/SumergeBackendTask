package com.demo.example.topic;

import com.demoBean.topic.TopicServicePlayGround;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    @Qualifier("explicitTopicService")
    private TopicServicePlayGround topicService;

    @GetMapping( "/topics")
    public List<com.demoBean.topic.TopicPlayGround> getAllTopics() {
        System.out.println(topicService.isPlayground);
            return topicService.getAllTopics();
    }

    @GetMapping("/topics/{id}")
    public com.demoBean.topic.TopicPlayGround getTopic(@PathVariable Integer id){
        return topicService.getTopic(id);
    }

    @PostMapping(value = "/topics", consumes = {"application/json"})
    public void addTopic(@RequestBody com.demoBean.topic.TopicPlayGround topic){
        topicService.addTopic(topic);
    }

    @PutMapping(value = "/topics/{id}", consumes = {"application/json"})
    public void addTopic(@PathVariable String id, @RequestBody com.demoBean.topic.TopicPlayGround topic){
        topicService.updateTopic(topic);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable Integer id){
        topicService.deleteTopic(id);
    }
}
