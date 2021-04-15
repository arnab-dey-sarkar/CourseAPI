package io.nextgen.technologies.course;


import io.nextgen.technologies.course.Course;
import io.nextgen.technologies.course.CourseService;
import io.nextgen.technologies.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
	
	@Autowired
	CourseService courseService;
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getCourses(@PathVariable("id") String id)
	{
		return courseService.getCourses(id);
	}
	@RequestMapping("/topics/{id}/courses/{courseId}")
	public Course getCourse(@PathVariable("courseId") String courseId)
	{
		return courseService.getCourse(courseId);
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/topics/{id}/courses")
	public void addCourses(@PathVariable("id") String topicId,@RequestBody Course t)
	{
		t.setTopic(new Topic(topicId,"",""));
		courseService.addCourses(t);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}/courses/{courseId}")
	public void updateCourse(@RequestBody Course t,@PathVariable("id") String topicId)
	{
		t.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(t);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}/courses/{courseId}")
	public void deleteCourse(@PathVariable String id)
	{
		courseService.deleteCourse(id);
	}

}
