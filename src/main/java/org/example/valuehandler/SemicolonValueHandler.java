package org.example.valuehandler;

import org.example.util.ValidationResult;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.example.util.ParserUtils.isInRange;
import static org.example.util.ParserUtils.isNumeric;

public class SemicolonValueHandler extends AbstractValueHandler  {

    String specialChar = ",";

    public SemicolonValueHandler(Integer lowRange, Integer highRange) {
        super(lowRange, highRange);
    }


    @Override
    ValidationResult validValue(String input) {
        ValidationResult result = new ValidationResult();
        if (input.contains(specialChar)) {
            result.setApplicable(true);
            String[] minuteSplit = input.split(specialChar);
            if (Arrays.stream(minuteSplit).anyMatch(it -> !isNumeric(it))) {
                result.getReason().add(ParserErrors.NOT_A_NUMBER.getReason());
                return result;
            }
            if (Arrays.stream(minuteSplit).anyMatch(it -> !isInRange(lowRange, highRange, it))) {
                result.getReason().add(ParserErrors.NOT_IN_RANGE.getReason());
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
        return String.join(" ", input.split(specialChar));
    }
}
