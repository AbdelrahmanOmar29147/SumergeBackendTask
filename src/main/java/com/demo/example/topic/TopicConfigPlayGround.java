package com.demo.example.topic;

import com.demoBean.topic.TopicServicePlayGround;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfigPlayGround {

    @Bean
//            (name = "explicitTopicService")
    public TopicServicePlayGround explicitTopicService() {
        TopicServicePlayGround explicitTopicService = new TopicServicePlayGround();
        explicitTopicService.setPlayground(true);
        return explicitTopicService;
    }

}
