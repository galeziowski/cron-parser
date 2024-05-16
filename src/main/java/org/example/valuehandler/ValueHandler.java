package org.example.valuehandler;

import org.example.util.ValidationResult;

public interface ValueHandler {

    ValidationResult parseValue(String input);
}
