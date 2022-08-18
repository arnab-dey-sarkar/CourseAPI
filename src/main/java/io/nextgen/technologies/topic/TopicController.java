package io.nextgen.technologies.topic;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TopicController {
	
	@Autowired
    TopicService topicService;
	@RequestMapping("/topics")
	public ResponseEntity<List<Topic>> getTopics()
	{
		List<Topic> topicList=topicService.getTopics();
		return new ResponseEntity<>(topicList,HttpStatus.ACCEPTED);
	}
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id)
	{
		try {
			return topicService.getTopic(id);
		}catch (Exception e)
		{
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error In Retrieving Data",e);
		}
		
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
