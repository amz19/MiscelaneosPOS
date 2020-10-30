package com.openbravo.pos.forms;

/**
 *
 */
public abstract class BeanFactoryCache implements BeanFactoryApp {
    
    private Object bean = null;

    public abstract Object constructBean(AppView app) throws BeanFactoryException;
           
    public void init(AppView app) throws BeanFactoryException {
        bean = constructBean(app);
    }
    
    public Object getBean() {
        return bean;
    }
}