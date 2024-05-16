package org.example.format;

import org.example.field.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandardFormat {

    List<Field> fields = List.of(new MinuteField(),
            new MonthField(),
            new DayOfMonthField(),
            new HourField(),
            new DayOfWeek(),
            new FreeTextField());

    private boolean validInputString(ParsingResult result, String input) {
        if (input == null || input.isEmpty()) {
            result.getErrorReason().add("Empty string");
            return false;
        }
        if (input.split("  *").length != fields.size()) {
            result.getErrorReason().add("Invalid number of params");
            return false;
        }
        return true;
    }

    public ParsingResult parseInputString(String input) {
        ParsingResult parsingResult = new ParsingResult();

        if (validInputString(parsingResult, input)){
            Map<Field, String> outputMap= new HashMap<>();
            String[] inputArray = input.split("  *");
            fields.forEach(field ->
                outputMap.put(field, field.parseValue(inputArray[field.getOrder()]))
            );
            parsingResult.setResult(outputMap);
        }
        return parsingResult;
    }
}
