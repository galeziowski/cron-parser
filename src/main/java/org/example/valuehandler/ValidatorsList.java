package org.example.valuehandler;

import java.util.ArrayList;
import java.util.List;

public class ValidatorsList {

    private final Integer lowRange;
    private final Integer highRange;
    private final List<ValueHandler> valueHandlerList = new ArrayList<>();

    public ValidatorsList(Integer lowRange, Integer highRange) {
        this.lowRange= lowRange;
        this.highRange= highRange;
    }

    public ValidatorsList withAsterixValueHandler(){
        this.valueHandlerList.add(new AsterixValueHandler(lowRange, highRange));
        return this;
    }

    public ValidatorsList withDashValueHandler(){
        this.valueHandlerList.add(new DashValueHandler(lowRange, highRange));
        return this;
    }

    public ValidatorsList withIntegerValueHandler(){
        this.valueHandlerList.add(new IntegerValueHandler(lowRange, highRange));
        return this;
    }

    public ValidatorsList withSemicolonValueHandler(){
        this.valueHandlerList.add(new SemicolonValueHandler(lowRange, highRange));
        return this;
    }

    public ValidatorsList withSteoValueHandler(){
        this.valueHandlerList.add(new StepValueHandler(lowRange, highRange));
        return this;
    }

    public List<ValueHandler> build(){
        return valueHandlerList;
    }
}
