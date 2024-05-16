package org.example.field;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FreeTextFieldTest {

    private Field freeText;

    @BeforeEach
    void setUp() {
        freeText = new FreeTextField();
    }

    @Test
    void testObjectSetup() {
        assertThat(freeText.getOrder()).isEqualTo(5);
        assertThat(freeText.getDisplayName()).isEqualTo("command");
    }

    @Test
    void testSingleValueParsing() {
        assertThat(freeText.parseValue("cos-tam")).isEqualTo("cos-tam");
    }

}
