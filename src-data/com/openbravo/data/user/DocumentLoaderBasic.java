package com.openbravo.data.user;

/**
 *
 *
 */
public class DocumentLoaderBasic implements DocumentLoader {
    
    public static final DocumentLoader INSTANCE = new DocumentLoaderBasic();
    
    /** Creates a new instance of DocumentLoaderBasic */
    private DocumentLoaderBasic() {
    }
    
    public Object getValue(Object key) {
        return key;
    }
    public Object getKey(Object value) {
        return value;
    }
}