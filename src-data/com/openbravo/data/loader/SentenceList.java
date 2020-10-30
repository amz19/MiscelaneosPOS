package com.openbravo.data.loader;

import java.util.List;
import com.openbravo.basic.BasicException;

public interface SentenceList {
    
    public List list() throws BasicException;
    public List list(Object... params) throws BasicException;
    public List list(Object params) throws BasicException;
    
    public List listPage(int offset, int length) throws BasicException;
    public List listPage(Object params, int offset, int length) throws BasicException;    
}