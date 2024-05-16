package org.example.field;

import org.example.valuehandler.*;

import java.util.List;

public class MinuteField extends FieldAbstract{

    public MinuteField() {
        super(0, "minute",
                new ValidatorsList(0, 59)
                        .withAsterixValueHandler()
                        .withDashValueHandler()
                        .withSemicolonValueHandler()
                        .withSteoValueHandler()
                        .withIntegerValueHandler()
                        .build());
    }
}
