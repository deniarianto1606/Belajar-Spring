/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.messaging.service.impl;

import com.learn.spring.messaging.entity.Mail;
import com.learn.spring.messaging.service.FrontDesk;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

/**
 *
 * @author DeNiSa
 */
public class FrontDeskImpl implements FrontDesk {

    @Override
    public void sendMail(Mail mail) {
        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Destination destination = new ActiveMQQueue("mail.queue");
        
        Connection conn = null;
        try {
            conn = cf.createConnection();
            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination);
            
            MapMessage message = session.createMapMessage();
            message.setString("mailId", mail.getMailId());
            message.setString("country", mail.getCountry());
            message.setDouble("weight", mail.getWeight());
            producer.send(message);
            
            session.close();
        } catch (JMSException ex) {
            Logger.getLogger(FrontDeskImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
