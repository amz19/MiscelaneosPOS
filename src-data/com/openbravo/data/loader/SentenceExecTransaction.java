package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 *
 */
public abstract class SentenceExecTransaction implements SentenceExec {
    
    private Session m_s;
    
    public SentenceExecTransaction(Session s) {
        m_s = s;
    }
    
    public final int exec() throws BasicException {
        return exec((Object) null);
    }

    public final int exec(Object... params) throws BasicException {
        return exec((Object) params);
    }

    public final int exec(final Object params) throws BasicException {
        
        Transaction<Integer> t = new Transaction<Integer>(m_s) {
            public Integer transact() throws BasicException{
                return execInTransaction(params);
            }
        };
        
        return t.execute();
    }
    
    protected abstract int execInTransaction(Object params) throws BasicException; 
}