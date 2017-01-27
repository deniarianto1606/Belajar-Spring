/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.security.custom.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

/**
 *
 * @author DeNiSa
 */
public class CustomAuthenticationLogoutSuccessHandler implements LogoutHandler {

    protected transient Logger LOGGER = Logger.getLogger(getClass());

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        try {
            //lakukan custom logout disini
            System.out.println("Success Logout");
            LOGGER.info(authentication.getName() + " Success Logout");
        } catch (Exception ex) {
            LOGGER.error("Error", ex);
        }
    }

}
