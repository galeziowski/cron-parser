package org.example.valuehandler;


import org.example.util.ValidationResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SemicolonValueHandlerTest {


    @Test
    void testSemicolonValueParsing() {
        ValueHandler semicolonValueHandler = new SemicolonValueHandler(1, 7);
        assertThat(semicolonValueHandler.parseValue("3,5").getParsedValue()).isEqualTo("3 5");
    }

    @Test
    void testSemicolonNotInRangeValueParsing() {
        ValueHandler semicolonValueHandler = new SemicolonValueHandler(1, 7);
        ValidationResult result = semicolonValueHandler.parseValue("44,66");
        assertThat(result.isValid()).isFalse();
        assertThat(result.getReason().get(0)).isEqualTo("Value not in range");
        assertThat(result.getParsedValue()).isNullOrEmpty();
    }

    @Test
    void testSemicolonGarbageValueParsing() {
        ValueHandler semicolonValueHandler = new SemicolonValueHandler(1, 7);
        ValidationResult result = semicolonValueHandler.parseValue("ff,fd");
        assertThat(result.isValid()).isFalse();
        assertThat(result.getReason().get(0)).isEqualTo("Not a number");
        assertThat(result.getParsedValue()).isNullOrEmpty();
    }

    @Test
    void testSemicolonWrongFormatValueParsing() {
        ValueHandler semicolonValueHandler = new SemicolonValueHandler(1, 7);
        ValidationResult result = semicolonValueHandler.parseValue("ff-fd");
        assertThat(result.isApplicable()).isFalse();
        assertThat(result.getReason().get(0)).isEqualTo("Value has wrong format");
        assertThat(result.getParsedValue()).isNullOrEmpty();
    }


}
