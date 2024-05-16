package org.example.field;

import org.example.valuehandler.*;

import java.util.List;

public class HourField extends FieldAbstract{

    public HourField() {
        super(1, "hour",
                new ValidatorsList(0, 23)
                        .withAsterixValueHandler()
                        .withDashValueHandler()
                        .withSemicolonValueHandler()
                        .withSteoValueHandler()
                        .withIntegerValueHandler()
                        .build());
    }
}
