package org.example.field;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonthTest {

    private Field month;

    @BeforeEach
    void setUp() {
        month = new MonthField();
    }

    @Test
    void testObjectSetup() {
        assertThat(month.getOrder()).isEqualTo(3);
        assertThat(month.getDisplayName()).isEqualTo("month");
    }

    @Test
    void testSingleValueParsing() {
        assertThat(month.parseValue("1")).isEqualTo("1");
    }

    @Test
    void testMaxRangeValueParsing() {
        assertThat(month.parseValue("1-7")).isEqualTo("1 2 3 4 5 6 7");
    }

    @Test
    void testOutOfRangeRangeValueParsing() {
        assertThat(month.parseValue("0-88")).isEqualTo("Failed to parse - Value not in range");
    }

    @Test
    void testSemicolonMaxRangeValueParsing() {
        assertThat(month.parseValue("1,2,3,4,5,6,7")).isEqualTo("1 2 3 4 5 6 7");
    }

    @Test
    void testSemicolonOutOfRangeRangeValueParsing() {
        assertThat(month.parseValue("0,1,2,3,4,5,6,7,8,9,10,11,12,14,22,33,44,55,77,88")).isEqualTo("Failed to parse - Value not in range");
    }

    @Test
    void testStepMaxRangeValueParsing() {
        assertThat(month.parseValue("*/4")).isEqualTo("4 8 12");
    }

    @Test
    void testStepOutOfRangeValueParsing() {
        assertThat(month.parseValue("*/19")).contains("Value can't be parsed to step values",
                "Field contains more than * character");
    }

    @Test
    void testEmptyValueParsing() {
        assertThat(month.parseValue("")).isEqualTo("Failed to parse - Not a valid value");
    }

    @Test
    void testGarbageValueParsing() {
        assertThat(month.parseValue("sdfsdf")).isEqualTo("Failed to parse - Not a valid value");
    }

}
