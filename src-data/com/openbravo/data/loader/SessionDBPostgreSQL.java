package com.openbravo.data.loader;

/**
 *
 */
public class SessionDBPostgreSQL implements SessionDB {

    public String TRUE() {
        return "True";
    }
    public String FALSE() {
        return "False";
    }
    public String INTEGER_NULL() {
        return "CAST(NULL AS INTEGER)";
    }
    public String CHAR_NULL() {
        return "CAST(NULL AS CHAR)";
    }

    public String getName() {
        return "PostgreSQL";
    }

    public SentenceFind getSequenceSentence(Session s, String sequence) {
        return new StaticSentence(s, "SELECT NEXTVAL('" + sequence + "')", null, SerializerReadInteger.INSTANCE);
    }
}