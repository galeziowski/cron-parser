package org.example.valuehandler;

import org.example.util.ValidationResult;

public abstract class AbstractValueHandler implements ValueHandler {

    protected final Integer lowRange;
    protected final Integer highRange;

    public AbstractValueHandler(Integer lowRange, Integer highRange) {
        this.lowRange = lowRange;
        this.highRange = highRange;
    }

    abstract ValidationResult validValue(String input);

    abstract String parseInput(String input);

    public ValidationResult parseValue(String input) {
        ValidationResult result = validValue(input);
        if (result.isApplicable() && result.isValid()) {
            result.setParsedValue(parseInput(input));
        }
        return result;
    }
}
