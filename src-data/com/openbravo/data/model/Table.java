package com.openbravo.data.model;

/**
 *
 */
public class Table {
    
    private String name;
    private Column[] columns;
    
    public Table(String name, Column... columns) {
        this.name = name;
        this.columns = columns;
    }
    
    public String getName() {
        return name;
    }
    
    public Column[] getColumns() {
        return columns;
    }
    
    public String getListSQL() {
        StringBuffer sent = new StringBuffer();
        sent.append("select ");

        for (int i = 0; i < columns.length; i ++) {
            if (i > 0) {
                sent.append(", ");
            }
            sent.append(columns[i].getName());
        }        
        
        sent.append(" from ");        
        sent.append(name);
        
        return sent.toString();          
    }   
    
    public String getInsertSQL() {
        
        StringBuffer sent = new StringBuffer();
        StringBuffer values = new StringBuffer();
        
        sent.append("insert into ");
        sent.append(name);
        sent.append(" (");        
        
        for (int i = 0; i < columns.length; i ++) {
            if (i > 0) {
                sent.append(", ");
                values.append(", ");
            }
            sent.append(columns[i].getName());
            values.append("?");
        }
        
        sent.append(") values (");
        sent.append(values.toString());
        sent.append(")");

        return sent.toString();       
    }    
    
    public String getUpdateSQL() {
        
        StringBuffer values = new StringBuffer();
        StringBuffer filter = new StringBuffer();
        
        for (int i = 0; i < columns.length; i ++) {
            if (columns[i].isPK()) {
                if (filter.length() == 0) {
                    filter.append(" where ");
                } else  {
                    filter.append(" and ");
                }
                filter.append(columns[i].getName());
                filter.append(" = ?");                
            } else {
                if (values.length() > 0) {
                    values.append(", ");
                }
                values.append(columns[i].getName());
                values.append(" = ?");                
            }
        }
        
        return "update " + name + " set " + values + filter;             
    }   
    
    public String getDeleteSQL() {
        
        StringBuffer filter = new StringBuffer();

        for (int i = 0; i < columns.length; i ++) {
            if (columns[i].isPK()) {
                if (filter.length() == 0) {
                    filter.append(" where ");
                } else  {
                    filter.append(" and ");
                }
                filter.append(columns[i].getName());
                filter.append(" = ?"); 
            }
        }
        
        return "delete from " + name + filter;     
    }    
}