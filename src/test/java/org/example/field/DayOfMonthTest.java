package org.example.field;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DayOfMonthTest {

    private Field dayOfMonth;

    @BeforeEach
    void setUp() {
        dayOfMonth = new DayOfMonthField();
    }

    @Test
    void testObjectSetup() {
        assertThat(dayOfMonth.getOrder()).isEqualTo(2);
        assertThat(dayOfMonth.getDisplayName()).isEqualTo("day of month");
    }

    @Test
    void testSingleValueParsing() {
        assertThat(dayOfMonth.parseValue("1")).isEqualTo("1");
    }

    @Test
    void testMaxRangeValueParsing() {
        assertThat(dayOfMonth.parseValue("1-7")).isEqualTo("1 2 3 4 5 6 7");
    }

    @Test
    void testOutOfRangeRangeValueParsing() {
        assertThat(dayOfMonth.parseValue("0-8")).isEqualTo("Failed to parse - Value not in range");
    }

    @Test
    void testSemicolonMaxRangeValueParsing() {
        assertThat(dayOfMonth.parseValue("1,2,3,4,5,6,7")).isEqualTo("1 2 3 4 5 6 7");
    }

    @Test
    void testSemicolonOutOfRangeRangeValueParsing() {
        assertThat(dayOfMonth.parseValue("0,1,2,3,4,5,6,7,8")).isEqualTo("Failed to parse - Value not in range");
    }

    @Test
    void testStepMaxRangeValueParsing() {
        assertThat(dayOfMonth.parseValue("*/1")).isEqualTo("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31");
    }

    @Test
    void testStepOutOfRangeValueParsing() {
        assertThat(dayOfMonth.parseValue("*/39")).contains("Value can't be parsed to step values",
                "Field contains more than * character");
    }

    @Test
    void testEmptyValueParsing() {
        assertThat(dayOfMonth.parseValue("")).isEqualTo("Failed to parse - Not a valid value");
    }

    @Test
    void testGarbageValueParsing() {
        assertThat(dayOfMonth.parseValue("sdfsdf")).isEqualTo("Failed to parse - Not a valid value");
    }

}
