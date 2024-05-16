package org.example.field;

import org.example.valuehandler.*;

import java.util.List;

public class DayOfWeek extends FieldAbstract{

    public DayOfWeek() {
        super(4, "day of week",
                new ValidatorsList(1, 7)
                        .withAsterixValueHandler()
                        .withDashValueHandler()
                        .withSemicolonValueHandler()
                        .withSteoValueHandler()
                        .withIntegerValueHandler()
                        .build());
    }
}
