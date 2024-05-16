package org.example.valuehandler;

import org.example.util.ValidationResult;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.example.util.ParserUtils.isInRange;

public class IntegerValueHandler extends AbstractValueHandler  {

    public IntegerValueHandler(Integer lowRange, Integer highRange) {
        super(lowRange, highRange);
    }

    @Override
    ValidationResult validValue(String input) {
        String regex = "[0-9]+";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        ValidationResult result = new ValidationResult();
        if (m.matches()) {
            result.setApplicable(true);
            if (isInRange(lowRange, highRange, input)) {
                result.setValid(true);
            } else {
                result.setValid(false);
                result.getReason().add(ParserErrors.NOT_IN_RANGE.getReason());
            }
        } else {
            result.setApplicable(false);
            result.getReason().add(ParserErrors.NOT_A_NUMBER.getReason());
        }

        return result;
    }

    @Override
    String parseInput(String input) {
        return input;
    }
}
