package com.demo.example.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Service
public class TopicService {

    public boolean isPlayground = false;

    public boolean isPlayground() {
        return isPlayground;
    }

    public void setPlayground(boolean playground) {
        isPlayground = playground;
    }

//    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<Topic>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(Integer id){
        return topicRepository.findById(id).orElse(null);
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic( Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopic( Integer id ) {
        topicRepository.deleteById(id);
    }
}
