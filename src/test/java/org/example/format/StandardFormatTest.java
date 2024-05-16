package org.example.format;

import org.example.OutputGenerator;
import org.example.field.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StandardFormatTest {

    @Test
    void parseInputString() {
        StandardFormat standardFormat = new StandardFormat();
        ParsingResult output = standardFormat.parseInputString("*/15 0 1,15 * 1-5 /usr/bin/find");
        assertThat(output.getResult().size()).isEqualTo(6);
        assertThat(output.getResult().values()).containsExactlyInAnyOrder("0 15 30 45",
                "1 2 3 4 5 6 7 8 9 10 11 12",
                "0",
                "1 2 3 4 5",
                "/usr/bin/find",
                "1 15");

        assertThat(output.getResult().keySet().stream().map(Field::getDisplayName).toList()).containsExactlyInAnyOrder("hour", "month", "day of week", "command", "minute", "day of month");

    }
}