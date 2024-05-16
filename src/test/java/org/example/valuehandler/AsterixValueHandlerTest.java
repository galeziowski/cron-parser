package org.example.valuehandler;


import org.example.util.ValidationResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class AsterixValueHandlerTest {


    @Test
    void testAsterixValueParsing() {
        ValueHandler asterixValueHandler = new AsterixValueHandler(1, 7);
        assertThat(asterixValueHandler.parseValue("*").getParsedValue()).isEqualTo("1 2 3 4 5 6 7");
    }

    @Test
    void testAsterixGarbageValueParsing() {
        ValueHandler asterixValueHandler = new AsterixValueHandler(1, 7);
        ValidationResult result = asterixValueHandler.parseValue("*sdds");
        assertThat(result.isValid()).isFalse();
        assertThat(result.getReason().get(0)).isEqualTo("Field contains more than * character");
        assertThat(result.getParsedValue()).isNullOrEmpty();
    }

    @Test
    void testAsterixWrongFormatValueParsing() {
        ValueHandler asterixValueHandler = new AsterixValueHandler(1, 7);
        ValidationResult result = asterixValueHandler.parseValue("ff-fd");
        assertThat(result.isApplicable()).isFalse();
        assertThat(result.getReason().get(0)).isEqualTo("Value has wrong format");
        assertThat(result.getParsedValue()).isNullOrEmpty();
    }

}
