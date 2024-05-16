package org.example.valuehandler;


import org.example.util.ValidationResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StepValueHandlerTest {


    @Test
    void testStepValueParsing() {
        ValueHandler stepValueHandler = new StepValueHandler(1, 7);
        assertThat(stepValueHandler.parseValue("*/2").getParsedValue()).isEqualTo("2 4 6");
    }

    @Test
    void testStepNotInRangeValueParsing() {
        ValueHandler stepValueHandler = new StepValueHandler(1, 7);
        ValidationResult result = stepValueHandler.parseValue("*/66");
        assertThat(result.isValid()).isFalse();
        assertThat(result.getReason().get(0)).isEqualTo("Value can't be parsed to step values");
        assertThat(result.getParsedValue()).isNullOrEmpty();
    }

    @Test
    void testStepGarbageValueParsing() {
        ValueHandler stepValueHandler = new StepValueHandler(1, 7);
        ValidationResult result = stepValueHandler.parseValue("*/fd");
        assertThat(result.isValid()).isFalse();
        assertThat(result.getReason().get(0)).isEqualTo("Not a number");
        assertThat(result.getParsedValue()).isNullOrEmpty();
    }

    @Test
    void testStepWrongFormatValueParsing() {
        ValueHandler stepValueHandler = new StepValueHandler(1, 7);
        ValidationResult result = stepValueHandler.parseValue("ff-fd");
        assertThat(result.isApplicable()).isFalse();
        assertThat(result.getReason().get(0)).isEqualTo("Value has wrong format");
        assertThat(result.getParsedValue()).isNullOrEmpty();
    }


}
