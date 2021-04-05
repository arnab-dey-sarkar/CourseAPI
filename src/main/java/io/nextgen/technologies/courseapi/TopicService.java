package io.nextgen.technologies.courseapi;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired private TopicRepository topicRepository;
	public List<Topic> getTopics()
	{
		return topicRepository.findAll();
	}
	public Topic getTopic(String id)
	{
		return topicRepository.findAll().stream().filter(t->t.getId().equals(id)).findFirst().get();
	}
	public void addTopics(Topic t)
	{
		topicRepository.save(t);
	}
	public void updateTopic(Topic t)
	{
		topicRepository.save(t);
	}
	public void deleteTopic(String id)
	{
		topicRepository.deleteById(id);
	}
}
