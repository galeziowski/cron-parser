package org.example.valuehandler;


import org.example.util.ValidationResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IntegerValueHandlerTest {


    @Test
    void testIntegerValueParsing() {
        ValueHandler integerValueHandler = new IntegerValueHandler(1, 7);
        assertThat(integerValueHandler.parseValue("5").getParsedValue()).isEqualTo("5");
    }

    @Test
    void testIntegerNotInRangeValueParsing() {
        ValueHandler integerValueHandler = new IntegerValueHandler(1, 7);
        ValidationResult result = integerValueHandler.parseValue("66");
        assertThat(result.isValid()).isFalse();
        assertThat(result.getReason().get(0)).isEqualTo("Value not in range");
        assertThat(result.getParsedValue()).isNullOrEmpty();
    }

    @Test
    void testIntegerGarbageValueParsing() {
        ValueHandler integerValueHandler = new IntegerValueHandler(1, 7);
        ValidationResult result = integerValueHandler.parseValue("ff-fd");
        assertThat(result.isApplicable()).isFalse();
        assertThat(result.getReason().get(0)).isEqualTo("Not a number");
        assertThat(result.getParsedValue()).isNullOrEmpty();
    }


}
