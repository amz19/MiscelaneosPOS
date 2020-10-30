package com.openbravo.data.loader;

/**
 *
 *
 */
public class KeyGetterBuilder implements IKeyGetter {
  
    public final static IKeyGetter INSTANCE = new KeyGetterBuilder();
    
    /** Creates a new instance of KeyGetterBuilder */
    public KeyGetterBuilder() {
    }
    
    public Object getKey(Object value) {
        
        return (value == null) 
            ? null
            : ((IKeyed) value).getKey();
    }   
}