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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DeNiSa
 */
@Controller
@RequestMapping("/messageDelete*")
public class MessageDeleteController {
    @Autowired
    private MessageBoardService messageBoardService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String messageDelete(@RequestParam(required = true, value="messageId") Long messageId, Model model){
        Message message = messageBoardService.findMessageById(messageId);
        messageBoardService.deleteMessage(message);
        model.addAttribute("messages", messageBoardService.listMessage());
        return "redirect:messageList";
    }
}
