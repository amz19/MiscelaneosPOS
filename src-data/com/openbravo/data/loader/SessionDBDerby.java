package com.openbravo.data.loader;

/**
 *
 */
public class SessionDBDerby implements SessionDB {

    public String TRUE() {
        return "1";
    }
    public String FALSE() {
        return "0";
    }
    public String INTEGER_NULL() {
        return "CAST(NULL AS INTEGER)";
    }
    public String CHAR_NULL() {
        return "CAST(NULL AS CHAR)";
    }

    public String getName() {
        return "Derby";
    }

    public SentenceFind getSequenceSentence(Session s, String sequence) {
        return new SequenceForDerby(s, sequence);
    }
}