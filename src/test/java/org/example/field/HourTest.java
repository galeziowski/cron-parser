package org.example.field;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HourTest {

    private Field hourField;

    @BeforeEach
    void setUp() {
        hourField = new HourField();
    }

    @Test
    void testObjectSetup() {
        assertThat(hourField.getOrder()).isEqualTo(1);
        assertThat(hourField.getDisplayName()).isEqualTo("hour");
    }

    @Test
    void testSingleValueParsing() {
        assertThat(hourField.parseValue("1")).isEqualTo("1");
    }

    @Test
    void testMaxRangeValueParsing() {
        assertThat(hourField.parseValue("1-7")).isEqualTo("1 2 3 4 5 6 7");
    }

    @Test
    void testOutOfRangeRangeValueParsing() {
        assertThat(hourField.parseValue("0-44")).isEqualTo("Failed to parse - Value not in range");
    }

    @Test
    void testSemicolonMaxRangeValueParsing() {
        assertThat(hourField.parseValue("1,2,3,4,5,6,7")).isEqualTo("1 2 3 4 5 6 7");
    }

    @Test
    void testSemicolonOutOfRangeRangeValueParsing() {
        assertThat(hourField.parseValue("0,1,2,3,4,5,6,7,8,9,10,11,12,14,22,33,44,55")).isEqualTo("Failed to parse - Value not in range");
    }

    @Test
    void testStepMaxRangeValueParsing() {
        assertThat(hourField.parseValue("*/4")).isEqualTo("0 4 8 12 16 20");
    }

    @Test
    void testStepOutOfRangeValueParsing() {
        assertThat(hourField.parseValue("*/33")).isEqualTo("0");
    }

    @Test
    void testEmptyValueParsing() {
        assertThat(hourField.parseValue("")).isEqualTo("Failed to parse - Not a valid value");
    }

    @Test
    void testGarbageValueParsing() {
        assertThat(hourField.parseValue("sdfsdf")).isEqualTo("Failed to parse - Not a valid value");
    }

}
