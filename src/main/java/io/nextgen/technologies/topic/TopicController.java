package io.nextgen.technologies.topic;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
    TopicService topicService;
	@RequestMapping("/topics")
	public List<Topic> getTopics()
	{
		return topicService.getTopics();
	}
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id)
	{
		return topicService.getTopic(id);
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void addTopics(@RequestBody Topic t)
	{
		topicService.addTopics(t);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@RequestBody Topic t)
	{
		topicService.updateTopic(t);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		topicService.deleteTopic(id);
	}

}