package com.xuqian.mo.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * Created by xuqian on 04/07/17.
 */
@Service("AppContext")
public final class AppContext implements ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(AppContext.class);
    private static ApplicationContext context;

    private AppContext(){
        /**/
    }

    public static <T> T getBean(String beanName, Class<T> clz) {
        if (null == beanName) {
            return  null;
        }
        try {
            return context.getBean(beanName,clz);
        } catch (Exception e) {
            logger.error("Unknown Bean NAme :" + beanName + ", Class :" + clz.toString(), e);
        }
    }

    public static Object getBean(String beanName) {
        if (null == beanName) {
            return null;
        }
        Object bean = null;
        try {
            bean = context.getBean(beanName);
        } catch (Exception e) {
            logger.error("Unknown Bean Name :" + beanName, e);
        }
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
