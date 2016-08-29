/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.messaging.service;

import com.learn.spring.messaging.entity.Mail;

/**
 *
 * @author DeNiSa
 */
public interface BackOffice {
    public Mail receiveMail();
}
