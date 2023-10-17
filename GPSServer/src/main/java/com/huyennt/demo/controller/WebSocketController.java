package com.huyennt.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.huyennt.demo.model.Message;

@Controller
public class WebSocketController {

	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;

	@MessageMapping("/application")
	@SendTo("/all/messages")
	public Message send(final Message message) throws Exception {
		System.out.println(message.toString());
		return message;
		
	}
}
