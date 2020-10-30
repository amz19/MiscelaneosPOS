package com.openbravo.data.loader;

/**
 *
 */
public class SessionDBHSQLDB implements SessionDB {

    public String TRUE() {
        return "TRUE";
    }
    public String FALSE() {
        return "FALSE";
    }
    public String INTEGER_NULL() {
        return "CAST(NULL AS INTEGER)";
    }
    public String CHAR_NULL() {
        return "CAST(NULL AS CHAR)";
    }

    public String getName() {
        return "HSQLDB";
    }

    public SentenceFind getSequenceSentence(Session s, String sequence) {
        return new StaticSentence(s, "CALL NEXT VALUE FOR " + sequence, null, SerializerReadInteger.INSTANCE);
    }
}