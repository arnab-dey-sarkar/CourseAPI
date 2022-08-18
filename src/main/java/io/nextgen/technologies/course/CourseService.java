package io.nextgen.technologies.course;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CourseService {
	@Autowired private CourseRepository courseRepository;
	public List<Course> getCourses(String topicId)
	{
		return courseRepository.findByTopicId(topicId);
	}
	public Course getCourse(String id)
	{
		return courseRepository.findAll().stream().filter(t->t.getId().equals(id)).findFirst().get();
	}
	public void addCourses(Course t)
	{
		courseRepository.save(t);
	}
	public void updateCourse(Course t)
	{
		courseRepository.save(t);
	}
	public void deleteCourse(String id)
	{
		courseRepository.deleteById(id);
	}

}
