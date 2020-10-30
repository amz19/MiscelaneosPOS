package com.openbravo.possync;

import com.openbravo.pos.forms.AppView;
import com.openbravo.pos.forms.BeanFactoryCache;
import com.openbravo.pos.forms.BeanFactoryException;
import com.openbravo.pos.forms.DataLogicSales;
import com.openbravo.pos.forms.DataLogicSystem;

/**
 *
 */
public class ProductsSyncCreate extends BeanFactoryCache {
    
    public Object constructBean(AppView app) throws BeanFactoryException {
        
        DataLogicSystem dlSystem = (DataLogicSystem) app.getBean("com.openbravo.pos.forms.DataLogicSystem");
        DataLogicIntegration dli = (DataLogicIntegration) app.getBean("com.openbravo.possync.DataLogicIntegration");
        DataLogicSales dlsales = (DataLogicSales) app.getBean("com.openbravo.pos.forms.DataLogicSales");

        ProductsSync bean = new ProductsSync(dlSystem, dli, dlsales, app.getInventoryLocation());
        return bean;
    }
}