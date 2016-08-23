/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.rest.hibernate.util;

import com.google.gson.GsonBuilder;

/**
 *
 * @author DeNiSa
 */
public class JsonUtil {

    public static GsonBuilder getHibernateEntityGsonBuilder() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        gsonBuilder.setDateFormat("dd MMMM yyyy hh:mm:ss a");
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyIdOnlyTypeAdapter.FACTORY);
        gsonBuilder.setExclusionStrategies(new EntityExclusionStrategy());
        return gsonBuilder;
    }
}
