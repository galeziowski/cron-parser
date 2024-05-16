package org.example;

import org.example.format.StandardFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputGeneratorTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void properCronStringParsing() {
        String input = "*/15 0 1,15 * 1-5 /usr/bin/find";
        OutputGenerator.printOutput(new StandardFormat().parseInputString(input));

        assertThat(outputStreamCaptor.toString()
                .trim()).isEqualToIgnoringNewLines("minute        0 15 30 45\n" +
                "hour          0\n" +
                "day of month  1 15\n" +
                "month         1 2 3 4 5 6 7 8 9 10 11 12\n" +
                "day of week   1 2 3 4 5\n" +
                "command       /usr/bin/find");
    }

    @Test
    void malformedCronStringParsing() {
        String input = "*/15 0 1,15 * 1-5 /usr/bin/find 0 4 2";
        OutputGenerator.printOutput(new StandardFormat().parseInputString(input));

        assertThat(outputStreamCaptor.toString()
                .trim()).isEqualToIgnoringNewLines("Invalid number of params");
    }

    @Test
    void emptyCronStringParsing() {
        String input = "";
        OutputGenerator.printOutput(new StandardFormat().parseInputString(input));

        assertThat(outputStreamCaptor.toString()
                .trim()).isEqualToIgnoringNewLines("Empty string");
    }

    @Test
    void nullCronStringParsing() {
        String input=null;
        OutputGenerator.printOutput(new StandardFormat().parseInputString(input));

        assertThat(outputStreamCaptor.toString()
                .trim()).isEqualToIgnoringNewLines("Empty string");
    }

}
