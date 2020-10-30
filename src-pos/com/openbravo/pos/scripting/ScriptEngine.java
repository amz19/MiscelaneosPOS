package com.openbravo.pos.scripting;

/**
 *
 *
 */
public interface ScriptEngine {
    
    public void put(String key, Object value);
    public Object get(String key);
    
    public Object eval(String src) throws ScriptException;
    
}