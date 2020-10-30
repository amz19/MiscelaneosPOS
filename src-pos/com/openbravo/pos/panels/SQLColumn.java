package com.openbravo.pos.panels;

import java.util.Enumeration;
import javax.swing.tree.TreeNode;

/**
 *
 */
public class SQLColumn implements TreeNode {
    
    private SQLTable m_table;
    private String m_sName;
    
    /** Creates a new instance of SQLColumn */
    public SQLColumn(SQLTable t, String name) {
        m_table = t;
        m_sName = name;
    }
    public String toString() {
        return m_sName;
    }
    
    public Enumeration children(){
        return null;
    }
    public boolean getAllowsChildren() {
        return false;
    }
    public TreeNode getChildAt(int childIndex) {
        throw new ArrayIndexOutOfBoundsException();
    }
    public int getChildCount() {
        return 0;
    }
    public int getIndex(TreeNode node){
        throw new ArrayIndexOutOfBoundsException();
    }
    public TreeNode getParent() {
        return m_table;
    }
    public boolean isLeaf() {
        return true;
    }      
}