/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.security.service;

import com.learn.spring.security.entity.Message;
import java.util.List;

/**
 *
 * @author DeNiSa
 */
public interface MessageBoardService {
    public List<Message> listMessage();
    public void postMessage(Message message);
    public void deleteMessage(Message message);
    public Message findMessageById(Long messageId);
}
