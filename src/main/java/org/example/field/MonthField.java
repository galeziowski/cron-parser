package org.example.field;

import org.example.valuehandler.*;

import java.util.List;

public class MonthField extends FieldAbstract{

    public MonthField() {
        super(3, "month",
                new ValidatorsList(1, 12)
                        .withAsterixValueHandler()
                        .withDashValueHandler()
                        .withSemicolonValueHandler()
                        .withSteoValueHandler()
                        .withIntegerValueHandler()
                        .build());
    }
}
