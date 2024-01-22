package com.demo.example.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(Integer topicId){
        System.out.println(topicId);
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        System.out.println(courseRepository.findByTopicId(topicId));
        return courses;
    }

    public Course getCourse(Integer id){
        return courseRepository.findById(id).orElse(null);
    }

    public void addCourse(Course topic) {
        courseRepository.save(topic);
    }

    public void updateCourse( Course topic) {
        courseRepository.save(topic);
    }

    public void deleteCourse( Integer id ) {
        courseRepository.deleteById(id);
    }
}
