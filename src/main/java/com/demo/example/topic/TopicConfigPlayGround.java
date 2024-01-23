package com.demo.example.topic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfigPlayGround {

    @Bean(name = "explicitTopicService")
    public TopicService explicitTopicService() {
        TopicService explicitTopicService = new TopicService();
        explicitTopicService.setPlayground(true);
        return explicitTopicService;
    }

}
