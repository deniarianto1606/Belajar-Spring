/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.security.web;

import com.learn.spring.security.entity.Message;
import com.learn.spring.security.service.MessageBoardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author DeNiSa
 */
@Controller
@RequestMapping("/messageList*")
public class MessageListController {
    @Autowired
    private MessageBoardService messageBoardService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String generateList(Model model){
        List<Message> messages = java.util.Collections.emptyList();
        messages = messageBoardService.listMessage();
        model.addAttribute("messages", messages);
        return "messageList";
    }
}
