package org.example.valuehandler;

public enum ParserErrors {

    NOT_VALID("Not a valid value"),
    NOT_IN_RANGE("Value not in range"),
    MORE_THAN_ASTERIX("Field contains more than * character"),
    NOT_A_NUMBER("Not a number"),
    NOT_A_STEP_VALUE("Value can't be parsed to step values"),
    WRONG_FORMAT("Value has wrong format");

    String reason;

    ParserErrors(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}
