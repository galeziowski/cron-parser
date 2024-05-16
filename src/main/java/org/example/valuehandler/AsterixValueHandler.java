package org.example.valuehandler;

import org.example.util.ValidationResult;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AsterixValueHandler extends AbstractValueHandler {

    String specialChar = "*";

    public AsterixValueHandler(Integer lowRange, Integer highRange) {

        super(lowRange, highRange);

    }

    ValidationResult validValue(String input) {

        ValidationResult result = new ValidationResult();
        if (input.contains(specialChar)) {
            result.setApplicable(true);
            if (input.length() > 1) {
                result.getReason().add(ParserErrors.MORE_THAN_ASTERIX.getReason());
                return result;
            }
            result.setValid(true);
        } else {
            result.setApplicable(false);
            result.getReason().add(ParserErrors.WRONG_FORMAT.getReason());
        }
        return result;
    }

    @Override
    String parseInput(String input) {
        return Arrays.stream(IntStream.rangeClosed(lowRange, highRange)
                        .toArray())
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
