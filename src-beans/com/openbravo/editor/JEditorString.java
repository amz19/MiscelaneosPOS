package com.openbravo.editor;

public class JEditorString extends JEditorText {
    
    /** Creates a new instance of JEditorString */
    public JEditorString() {
        super();
    }
    
    protected final int getMode() {
        return EditorKeys.MODE_STRING;
    }
        
    protected int getStartMode() {
        return MODE_Abc1;
    }
    
}