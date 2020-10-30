package com.openbravo.pos.admin;

import javax.swing.ListCellRenderer;
import com.openbravo.data.gui.ListCellRendererBasic;
import com.openbravo.data.loader.ComparatorCreator;
import com.openbravo.data.loader.TableDefinition;
import com.openbravo.data.loader.Vectorer;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.ListProvider;
import com.openbravo.data.user.ListProviderCreator;
import com.openbravo.data.user.SaveProvider;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.panels.JPanelTable;

/**
 *
 */
public class RolesPanel extends JPanelTable {
    
    private TableDefinition troles;
    private RolesView jeditor;
    
    /** Creates a new instance of RolesPanel */
    public RolesPanel() {
     }
    
    protected void init() {
        DataLogicAdmin dlAdmin  = (DataLogicAdmin) app.getBean("com.openbravo.pos.admin.DataLogicAdmin");        
        troles = dlAdmin.getTableRoles();                 
        jeditor = new RolesView(dirty);
    }
    
    public ListProvider getListProvider() {
        return new ListProviderCreator(troles);
    }
    
    public SaveProvider getSaveProvider() {
        return new SaveProvider(troles);        
    }
    
    public Vectorer getVectorer() {
        return troles.getVectorerBasic(new int[] {1});
    }
    
    public ComparatorCreator getComparatorCreator() {
        return troles.getComparatorCreator(new int[] {1});
    }
    
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(troles.getRenderStringBasic(new int[] {1}));
    }
    
    public EditorRecord getEditor() {
        return jeditor;
    }
    
    public String getTitle() {
        return AppLocal.getIntString("Menu.Roles");
    }        
}