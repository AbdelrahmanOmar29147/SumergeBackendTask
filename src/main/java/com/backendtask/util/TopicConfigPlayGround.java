package com.backendtask.util;

import com.backendtask.topic.TopicService;
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
