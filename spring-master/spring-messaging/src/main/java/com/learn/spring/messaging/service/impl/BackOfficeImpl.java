/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.messaging.service.impl;

import com.learn.spring.messaging.entity.Mail;
import com.learn.spring.messaging.service.BackOffice;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

/**
 *
 * @author DeNiSa
 */
public class BackOfficeImpl implements BackOffice {

    @Override
    public Mail receiveMail() {
        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Destination destination = new ActiveMQQueue("mail.queue");
        
        Connection conn = null;
        try {
            conn = cf.createConnection();
            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(destination);
            
            conn.start();
            MapMessage message = (MapMessage) consumer.receive();
            Mail mail = new Mail();
            mail.setMailId(message.getString("mailId"));
            mail.setCountry(message.getString("country"));
            mail.setWeight(message.getDouble("weight"));
            
            session.close();
            return mail;
        } catch (JMSException ex) {
            Logger.getLogger(BackOfficeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
