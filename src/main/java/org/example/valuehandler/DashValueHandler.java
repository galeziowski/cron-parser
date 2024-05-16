package org.example.valuehandler;

import org.example.util.ValidationResult;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.example.util.ParserUtils.isInRange;
import static org.example.util.ParserUtils.isNumeric;

public class DashValueHandler extends AbstractValueHandler  {

    String specialChar = "-";

    public DashValueHandler(Integer lowRange, Integer highRange) {
        super(lowRange, highRange);
    }

    @Override
    ValidationResult validValue(String input) {
        ValidationResult result = new ValidationResult();

        if (input.contains(specialChar)) {
            result.setApplicable(true);
            String[] minuteSplit = input.split("-");
            if (Arrays.stream(minuteSplit).anyMatch(it -> !isNumeric(it))) {
                result.getReason().add(ParserErrors.NOT_A_NUMBER.getReason());
                return result;
            }
            if (!isInRange(lowRange, highRange, minuteSplit[0]) || !isInRange(lowRange, highRange, minuteSplit[1])) {
                result.getReason().add(ParserErrors.NOT_IN_RANGE.getReason());
                return result;
            }
            result.setValid(true);
        } else  {
            result.setApplicable(false);
            result.getReason().add(ParserErrors.WRONG_FORMAT.getReason());
        }
        return result;
    }

    @Override
    String parseInput(String input) {
        String[] minuteSplit = input.split(specialChar);
        return Arrays.stream(IntStream.rangeClosed(Integer.parseInt(minuteSplit[0]), Integer.parseInt(minuteSplit[1]))
                        .toArray())
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
