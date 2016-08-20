/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.security.service.impl;

import com.learn.spring.security.entity.Message;
import com.learn.spring.security.service.MessageBoardService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DeNiSa
 */
public class MessageBoardServiceImpl implements MessageBoardService {

    private Map<Long, Message> messages = new LinkedHashMap<Long,Message>();
    
    @Override
    public List<Message> listMessage() {
        return new ArrayList<Message>(messages.values());
    }

    @Override
    public synchronized void postMessage(Message message) {
        message.setId(System.currentTimeMillis());
        messages.put(message.getId(), message);
    }

    @Override
    public void deleteMessage(Message message) {
        messages.remove(message.getId());
    }

    @Override
    public Message findMessageById(Long messageId) {
        return messages.get(messageId);
    }
    
}
