package com.hibernate.event;

import com.hibernate.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.event.spi.LoadEvent;
import org.hibernate.event.spi.LoadEventListener;

public class LoadEventLitenerImp implements LoadEventListener {

    private static final Logger logger = LogManager.getLogger(LoadEventLitenerImp.class);
    private static final long serialVersionUID = 1L;

    @Override
    public void onLoad(LoadEvent event, LoadType loadType) throws HibernateException {
        logger.info("onLoad is Called.");
        Object object = event.getResult();
        if (object instanceof Person) {
            Person person = (Person) object;
            logger.info(person);
        }
    }

}
