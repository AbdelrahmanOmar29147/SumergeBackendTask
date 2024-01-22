package com.demo.example.course;

import com.demo.example.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping( "/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable Integer topicId){
        return courseService.getAllCourses(topicId);
    }

    @GetMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable Integer id){
        return courseService.getCourse(id);
    }

    @PostMapping(value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable Integer topicId){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @PutMapping(value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@PathVariable Integer id, @RequestBody Course course, @PathVariable Integer topicId){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @DeleteMapping("/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
    }
}
