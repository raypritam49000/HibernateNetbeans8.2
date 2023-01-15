package com.hibernate.event;

import com.hibernate.model.Person;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.event.spi.RefreshEvent;
import org.hibernate.event.spi.RefreshEventListener;

public class RefreshEventListenerImp implements RefreshEventListener {

    private static final Logger logger = LogManager.getLogger(RefreshEventListenerImp.class);
    private static final long serialVersionUID = 1L;

    @Override
    public void onRefresh(RefreshEvent event) throws HibernateException {
        logger.info("onRefresh is Called.");
        Object object = event.getObject();
        if(object instanceof Person){
          Person person = (Person)object;
          logger.info(person);
      }

    }
    
    @SuppressWarnings("rawtypes")
    @Override
    public void onRefresh(RefreshEvent event, Map refreshedAlready) throws HibernateException {
       logger.info("onRefresh is Called."); 
    }
}
