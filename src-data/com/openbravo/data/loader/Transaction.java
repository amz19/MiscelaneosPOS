package com.openbravo.data.loader;

import java.sql.SQLException;
import com.openbravo.basic.BasicException;

/**
 *
 *
 */
public abstract class Transaction<T> {
    
    private Session s;
    
    /** Creates a new instance of Transaction */
    public Transaction(Session s) {
        this.s = s;
    }
    
    public final T execute() throws BasicException {
        
        if (s.isTransaction()) {
            return transact();
        } else {
            try {
                try {    
                    s.begin();
                    T result = transact();
                    s.commit();
                    return result;
                } catch (BasicException e) {
                    s.rollback();
                    throw e;
                }
            } catch (SQLException eSQL) {
                throw new BasicException("Transaction error", eSQL);
            }
        }
    }
    
    protected abstract T transact() throws BasicException;
}