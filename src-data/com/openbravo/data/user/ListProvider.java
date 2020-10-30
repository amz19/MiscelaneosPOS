package com.openbravo.data.user;

import java.util.List;
import com.openbravo.basic.BasicException;

public interface ListProvider {

    public List loadData() throws BasicException;    
    public List refreshData() throws BasicException; 
}