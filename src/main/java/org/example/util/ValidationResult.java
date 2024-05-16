package org.example.util;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

    boolean isApplicable;
    boolean isValid;
    List<String> reason= new ArrayList<>();
    String parsedValue;

    public String getParsedValue() {
        return parsedValue;
    }

    public void setParsedValue(String parsedValue) {
        this.parsedValue = parsedValue;
    }

    public void setApplicable(boolean applicable) {
        isApplicable = applicable;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public boolean isApplicable() {
        return isApplicable;
    }

    public boolean isValid() {
        return isValid;
    }

    public List<String> getReason() {
        return reason;
    }
}
