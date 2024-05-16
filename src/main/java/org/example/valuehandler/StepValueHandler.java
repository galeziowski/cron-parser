package org.example.valuehandler;

import org.example.util.ValidationResult;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.example.util.ParserUtils.isNumeric;

public class StepValueHandler extends AbstractValueHandler  {

    String specialChar = "*/";
    String specialCharRegex = "\\*/";

    public StepValueHandler(Integer lowRange, Integer highRange) {
        super(lowRange, highRange);
    }

    @Override
    ValidationResult validValue(String input) {
        ValidationResult result = new ValidationResult();
        if (input.contains(specialChar)) {
            result.setApplicable(true);
            String inputFormatted = input.replaceAll(specialCharRegex, "");
            if (!isNumeric(inputFormatted)) {
                result.setValid(false);
                result.getReason().add(ParserErrors.NOT_A_NUMBER.getReason());
                return result;
            }
            int step = Integer.parseInt(inputFormatted);
            boolean notInRange = IntStream.rangeClosed(lowRange, highRange)
                    .boxed()
                    .noneMatch(number -> number % step == 0);
            if (notInRange) {
                result.getReason().add(ParserErrors.NOT_A_STEP_VALUE.getReason());
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
        int step = Integer.parseInt(input.replaceAll(specialCharRegex, ""));
        return IntStream.rangeClosed(lowRange, highRange)
                .boxed()
                .filter(number -> number % step == 0)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
