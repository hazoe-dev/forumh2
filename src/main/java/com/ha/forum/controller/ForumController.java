package com.ha.forum.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ha.forum.model.Forum;
import com.ha.forum.model.ReplyMessage;
import com.ha.forum.model.Topic;
import com.ha.forum.model.User;
import com.ha.forum.service.IForumService;
import com.ha.forum.service.ITopicService;
import com.ha.forum.service.IUserService;

@Controller
@RequestMapping("/")
public class ForumController {
	@Autowired
	private HttpSession httpSession;
	@Autowired
	private IUserService userService;
	@Autowired
	private IForumService forumService;
	@Autowired
	private ITopicService topicService;
	@GetMapping()
	public ModelAndView getLogin() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute LoginForm form) {
		ModelAndView mav = new ModelAndView("login");
		User user = userService.checkUsername(form.getUsername(), form.getPassword());
		if (user != null) {
			httpSession.setAttribute("user", user);
			return new ModelAndView("redirect:/list");
		} else {
			return mav;
		}
	}

	@GetMapping("/logout")
	public ModelAndView logout() {
		httpSession.invalidate();
		return new ModelAndView("login");
	}

	@GetMapping("/list")
	public ModelAndView listTopics() {
		if ((User) httpSession.getAttribute("user") == null) {
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView("listTopics");
		List<Forum> forums = forumService.getForums();
		if(forums.size()==0) {
			return new ModelAndView("updateForum");
		}
		Long forumId = forums.get(0).getId();
		httpSession.setAttribute("forumId", forumId);
		Forum forum = forumService.getForum(forumId);
		mav.addObject(forum);
		return mav;
	}

	@GetMapping("/topic/{id}")
	public ModelAndView getTopic(@PathVariable Long id) {
		if ((User) httpSession.getAttribute("user") == null) {
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView("showTopic");
		Long forumId = (Long) httpSession.getAttribute("forumId");
		Topic topic = topicService.getTopicByIdAndForum(id, forumId); 
		mav.addObject(topic);
		return mav;
	}
	
	@GetMapping("/topic")
	public ModelAndView showNewTopic() {
		if ((User) httpSession.getAttribute("user") == null) {
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("newTopic");
	}
	
	@PostMapping("/newtopic")
	public ModelAndView createTopic(@ModelAttribute MessageForm form) {
		User user =(User) httpSession.getAttribute("user");
		if ( user== null) {
			return new ModelAndView("redirect:/");
		}
		Topic topic = new Topic();
		topic.setContent( form.getContent());
		topic.setTitle(form.getTitle());
		topic.setCreator(user);
		topic.setCreatedTime(new Date());
		Long forumId = (Long) httpSession.getAttribute("forumId");
		Forum forum =forumService.getForum(forumId);
		topic.setForum(forum);
		Long id = forumService.addTopic(topic).getId();
		return new ModelAndView("redirect:/topic/"+id);
	}
	
	@GetMapping("/reply")
	public ModelAndView reply(@ModelAttribute ReplyForm form) {
		User user =(User) httpSession.getAttribute("user");
		if ( user== null) {
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav= new ModelAndView("replyTopic");
		httpSession.setAttribute("id", form.getId());
		httpSession.setAttribute("title", form.getTitle());
		return new ModelAndView("redirect:/replypage");
	}
	
	@GetMapping("/replypage")
	public ModelAndView reply() {
		User user =(User) httpSession.getAttribute("user");
		if ( user== null) {
			return new ModelAndView("redirect:/");
		}
		
		return new ModelAndView("replyTopic");
	}
	
	@PostMapping("/newreply")
	public ModelAndView createReply(@ModelAttribute MessageReplyForm form) {
		User user =(User) httpSession.getAttribute("user");
		if ( user== null) {
			return new ModelAndView("redirect:/");
		}
		ReplyMessage message = new ReplyMessage();
		message.setContent( form.getContent());
		message.setTitle(form.getTitle());
		message.setCreator(user);
		message.setCreatedTime(new Date());
		Topic topic = topicService.getTopic(form.getId());
		message.setTopic(topic);
		
		topicService.addReplyMessage(message);
		
		return new ModelAndView("redirect:/topic/"+form.getId());
	}
}

class MessageForm {
	private String title;
	private String content;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}

class MessageReplyForm {
	private Long id;//id topic
	private String title;
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}

class LoginForm {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

class ReplyForm {
	private Long id;
	private String title;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}