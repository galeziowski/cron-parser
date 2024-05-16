package org.example.field;

import org.example.util.ValidationResult;
import org.example.valuehandler.ParserErrors;
import org.example.valuehandler.ValueHandler;

import java.util.List;

public abstract class FieldAbstract implements Field {

    final int order;
    final String displayName;
    final List<ValueHandler> valueHandlers;

    public FieldAbstract(int order, String displayName, List<ValueHandler> valueHandlers) {
        this.order = order;
        this.displayName = displayName;
        this.valueHandlers = valueHandlers;
    }

    private ValidationResult validateValue(String inputValue) {
        ValidationResult outputValidationResult = new ValidationResult();
        if (valueHandlers.isEmpty()) {
            outputValidationResult.setValid(true);
            outputValidationResult.setParsedValue(inputValue);
            return outputValidationResult;
        }
        for (ValueHandler valueHandler : valueHandlers) {
            ValidationResult validationResult = valueHandler.parseValue(inputValue);
            if (validationResult.isApplicable() && validationResult.isValid()) {
                return validationResult;
            } else if (validationResult.isApplicable()) {
                outputValidationResult.getReason().addAll(validationResult.getReason());
            }
        }
        if (outputValidationResult.getReason().isEmpty()) {
            outputValidationResult.getReason().add(ParserErrors.NOT_VALID.getReason());
        }
        return outputValidationResult;
    }

    @Override
    public String parseValue(String inputValue) {
        ValidationResult result = validateValue(inputValue);
        if (result.isValid()) {
                return result.getParsedValue();
        } else {
            return "Failed to parse - "+ String.join(", ", result.getReason());
        }
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
