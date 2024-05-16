package org.example.field;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinuteTest {

    private Field miunute;

    @BeforeEach
    void setUp() {
        miunute = new MinuteField();
    }

    @Test
    void testObjectSetup() {
        assertThat(miunute.getOrder()).isEqualTo(0);
        assertThat(miunute.getDisplayName()).isEqualTo("minute");
    }

    @Test
    void testSingleValueParsing() {
        assertThat(miunute.parseValue("1")).isEqualTo("1");
    }

    @Test
    void testMaxRangeValueParsing() {
        assertThat(miunute.parseValue("1-7")).isEqualTo("1 2 3 4 5 6 7");
    }

    @Test
    void testOutOfRangeRangeValueParsing() {
        assertThat(miunute.parseValue("0-88")).isEqualTo("Failed to parse - Value not in range");
    }

    @Test
    void testSemicolonMaxRangeValueParsing() {
        assertThat(miunute.parseValue("1,2,3,4,5,6,7")).isEqualTo("1 2 3 4 5 6 7");
    }

    @Test
    void testSemicolonOutOfRangeRangeValueParsing() {
        assertThat(miunute.parseValue("0,1,2,3,4,5,6,7,8,9,10,11,12,14,22,33,44,55,77,88")).isEqualTo("Failed to parse - Value not in range");
    }

    @Test
    void testStepMaxRangeValueParsing() {
        assertThat(miunute.parseValue("*/4")).isEqualTo("0 4 8 12 16 20 24 28 32 36 40 44 48 52 56");
    }

    @Test
    void testStepOutOfRangeValueParsing() {
        assertThat(miunute.parseValue("*/99")).isEqualTo("0");
    }

    @Test
    void testEmptyValueParsing() {
        assertThat(miunute.parseValue("")).isEqualTo("Failed to parse - Not a valid value");
    }

    @Test
    void testGarbageValueParsing() {
        assertThat(miunute.parseValue("sdfsdf")).isEqualTo("Failed to parse - Not a valid value");
    }

}
