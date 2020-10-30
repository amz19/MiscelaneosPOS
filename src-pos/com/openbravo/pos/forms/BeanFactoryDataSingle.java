package com.openbravo.pos.forms;

import com.openbravo.data.loader.Session;

/**
 *
 */
public abstract class BeanFactoryDataSingle implements BeanFactoryApp {
    
    /** Creates a new instance of BeanFactoryData */
    public BeanFactoryDataSingle() {
    }
    
    public abstract void init(Session s);

    public void init(AppView app) throws BeanFactoryException {        
        init(app.getSession());                     
    }   
    
    public Object getBean() {
        return this;
    }  
}