package com.hibernate.event;

import com.hibernate.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.event.spi.SaveOrUpdateEventListener;

public class SaveUpdateEventListenerImp implements SaveOrUpdateEventListener{
    private static final Logger logger = LogManager.getLogger(SaveUpdateEventListenerImp.class);
    private static final long serialVersionUID = 1L;
            
    @Override
    public void onSaveOrUpdate(SaveOrUpdateEvent event) throws HibernateException {
      logger.info("onSaveorUpdate is called...");
      Object object = event.getEntity();
      if(object instanceof Person){
          Person person = (Person)object;
          logger.info(person);
      }
    }
    
}
