package org.example.valuehandler;


import org.example.util.ValidationResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DashValueHandlerTest {


    @Test
    void testDashValueParsing() {
        ValueHandler dashValueHandler = new DashValueHandler(1, 7);
        assertThat(dashValueHandler.parseValue("1-5").getParsedValue()).isEqualTo("1 2 3 4 5");
    }

    @Test
    void testDashNotInRangeValueParsing() {
        ValueHandler dashValueHandler = new DashValueHandler(1, 7);
        ValidationResult result = dashValueHandler.parseValue("1-66");
        assertThat(result.isValid()).isFalse();
        assertThat(result.getReason().get(0)).isEqualTo("Value not in range");
        assertThat(result.getParsedValue()).isNullOrEmpty();
    }

    @Test
    void testDashGarbageValueParsing() {
        ValueHandler dashValueHandler = new DashValueHandler(1, 7);
        ValidationResult result = dashValueHandler.parseValue("ff-fd");
        assertThat(result.isValid()).isFalse();
        assertThat(result.getReason().get(0)).isEqualTo("Not a number");
        assertThat(result.getParsedValue()).isNullOrEmpty();
    }

    @Test
    void testDashWrongFormatValueParsing() {
        ValueHandler dashValueHandler = new DashValueHandler(1, 7);
        ValidationResult result = dashValueHandler.parseValue("ff*fd");
        assertThat(result.isApplicable()).isFalse();
        assertThat(result.getReason().get(0)).isEqualTo("Value has wrong format");
        assertThat(result.getParsedValue()).isNullOrEmpty();
    }

}
