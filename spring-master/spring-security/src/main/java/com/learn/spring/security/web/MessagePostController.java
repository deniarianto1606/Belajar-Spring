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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author DeNiSa
 */
@Controller
@RequestMapping("/messagePost*")
public class MessagePostController {
    @Autowired
    private MessageBoardService messageBoardService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(Model model){
        Message message = new Message();
        model.addAttribute("message", message);
        return "messagePost";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("message") Message message, BindingResult result){
        if(result.hasErrors()){
            return "messagePost";
        }else{
            messageBoardService.postMessage(message);
            return "redirect:messageList";
        }
    }
}
