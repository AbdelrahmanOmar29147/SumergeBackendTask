package com.backendtask.topic;


import com.backendtask.util.NotFoundException;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@SpringBootTest()
public class TopicControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Autowired
    private TopicService topicService;

    @MockBean
    private TopicRepository topicRepository;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    Topic TOPIC_1 = new Topic(1, "Rayven Yor", "Cebu Philippines");
    Topic TOPIC_2 = new Topic(2, "Beedo Yor", "Cebu Argentine");
    Topic TOPIC_3 = new Topic(3, "Rayven Beedo", "Cebu Lorem");

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    public void getAllTopics_success() throws Exception {
        List<Topic> topics = new ArrayList<>(Arrays.asList(TOPIC_1, TOPIC_2, TOPIC_3));
        Mockito.when(topicRepository.findAll()).thenReturn(topics);

        mockMvc.perform(MockMvcRequestBuilders.get("/topics").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[2].name").value("Rayven Beedo"))
                .andExpect(jsonPath("$[2].length()", is(3)));
    }

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    public void getTopic_success() throws Exception {
        Mockito.when(topicRepository.findById(TOPIC_2.getId())).thenReturn(Optional.ofNullable(TOPIC_2));

        mockMvc.perform(MockMvcRequestBuilders.get("/topics/2").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("Beedo Yor")));
    }

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    public void getTopic_fail() throws Exception {
//        Mockito.when(topicService.getTopic(4)).thenThrow(NotFoundException.class);
        assertThrows(NotFoundException.class, () -> topicService.getTopic(4));
    }

//
//    @Test
//    @Timeout(value = 1, unit = TimeUnit.SECONDS)
//    public void getTopic_failWithRule() throws Exception {
//        //DOESN'T WORK
//        exceptionRule.expect(NotFoundException.class);
//        exceptionRule.expectMessage("USER WITH ID: 4 IS NOT FOUND");
////        Mockito.when(topicService.getTopic(4)).thenThrow(NotFoundException.class);
//        topicService.getTopic(1);
//    }
}