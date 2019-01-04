package com.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.app.model.entity.Message;
import com.app.model.form.MessageForm;
import com.app.model.repository.MessageRepository;

@RestController
@RequestMapping("/")
@CrossOrigin
public class IndexController {
	
	@Autowired
	private MessageRepository messageRepository;

	@RequestMapping(method = RequestMethod.GET)
    public List<Message> index() {
		//return new ArrayList<Message>();
        return messageRepository.findAll();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Message create(@RequestBody MessageForm messageForm) {
    	if (StringUtils.isEmpty(messageForm.message)) {
    		throw new IllegalArgumentException("message is empty");
    	}
    	Message message = messageRepository.save(new Message(messageForm.message));
    	return message;
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String emptyMsg(IllegalArgumentException e) {
    	return "{\"error\": \"" + e.getMessage() + "\"}";
    }

}
