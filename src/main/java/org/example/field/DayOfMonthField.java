package org.example.field;

import org.example.valuehandler.*;

import java.util.List;

public class DayOfMonthField extends FieldAbstract{

    public DayOfMonthField() {
        super(2, "day of month",
                new ValidatorsList(1, 31)
                        .withAsterixValueHandler()
                        .withDashValueHandler()
                        .withSemicolonValueHandler()
                        .withSteoValueHandler()
                        .withIntegerValueHandler()
                        .build());
    }
}
