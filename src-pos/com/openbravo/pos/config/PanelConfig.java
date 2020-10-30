package com.openbravo.pos.config;

import java.awt.Component;
import com.openbravo.pos.forms.AppConfig;

/**
 *
 */
public interface PanelConfig {
    public void loadProperties(AppConfig config);    
    public void saveProperties(AppConfig config);   
    public boolean hasChanged();
    public Component getConfigComponent();    
}