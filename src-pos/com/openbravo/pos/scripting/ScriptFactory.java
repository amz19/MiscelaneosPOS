package com.openbravo.pos.scripting;

/**
 *
 *
 */
public class ScriptFactory {
    
    public static final String VELOCITY = "velocity";
    public static final String BEANSHELL = "beanshell";
    public static final String RHINO = "rhino";
    
    /** Creates a new instance of ScriptFactory */
    private ScriptFactory() {
    }
    
    public static ScriptEngine getScriptEngine(String name) throws ScriptException {
        if (VELOCITY.equals(name)) {
            return new ScriptEngineVelocity();
        } else if (BEANSHELL.equals(name)) {
            return new ScriptEngineBeanshell();
//        } else if (RHINO.equals(name)) {
//            return new ScriptEngineRhino();
//        } else if (name.startsWith("generic:")) {
//            return new ScriptEngineGeneric(name.substring(8));            
        } else {
            throw new ScriptException("Script engine not found: " + name);
        }
    }    
}