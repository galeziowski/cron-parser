package org.example.field;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayOfWeekTest {

    private Field dayOfWeek;

    @BeforeEach
    void setUp() {
        dayOfWeek = new DayOfWeek();
    }

    @Test
    void testObjectSetup() {
        assertThat(dayOfWeek.getOrder()).isEqualTo(4);
        assertThat(dayOfWeek.getDisplayName()).isEqualTo("day of week");
    }

    @Test
    void testSingleValueParsing() {
        assertThat(dayOfWeek.parseValue("1")).isEqualTo("1");
    }

    @Test
    void testMaxRangeValueParsing() {
        assertThat(dayOfWeek.parseValue("1-7")).isEqualTo("1 2 3 4 5 6 7");
    }

    @Test
    void testOutOfRangeRangeValueParsing() {
        assertThat(dayOfWeek.parseValue("0-8")).isEqualTo("Failed to parse - Value not in range");
    }

    @Test
    void testSemicolonMaxRangeValueParsing() {
        assertThat(dayOfWeek.parseValue("1,2,3,4,5,6,7")).isEqualTo("1 2 3 4 5 6 7");
    }

    @Test
    void testSemicolonOutOfRangeRangeValueParsing() {
        assertThat(dayOfWeek.parseValue("0,1,2,3,4,5,6,7,8")).isEqualTo("Failed to parse - Value not in range");
    }

    @Test
    void testStepMaxRangeValueParsing() {
        assertThat(dayOfWeek.parseValue("*/1")).isEqualTo("1 2 3 4 5 6 7");
    }

    @Test
    void testStepOutOfRangeValueParsing() {
        assertThat(dayOfWeek.parseValue("*/9")).contains("Value can't be parsed to step values",
                "Field contains more than * character");
    }

    @Test
    void testEmptyValueParsing() {
        assertThat(dayOfWeek.parseValue("")).isEqualTo("Failed to parse - Not a valid value");
    }

    @Test
    void testGarbageValueParsing() {
        assertThat(dayOfWeek.parseValue("sdfsdf")).isEqualTo("Failed to parse - Not a valid value");
    }

}
