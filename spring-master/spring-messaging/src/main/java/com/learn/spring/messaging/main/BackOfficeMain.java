/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.messaging.main;

import com.learn.spring.messaging.entity.Mail;
import com.learn.spring.messaging.service.BackOffice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author DeNiSa
 */
public class BackOfficeMain {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-back.xml");
        
        BackOffice backDesk = (BackOffice) context.getBean("backOffice");
        Mail mail = backDesk.receiveMail();
        System.out.println("Mail #" + mail.getMailId() + " received");
    }
}
