package org.example.format;

import org.example.field.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParsingResult {

    Map<Field, String> result;
    List<String> errorReason = new ArrayList<>();

    public Map<Field, String> getResult() {
        return result;
    }

    public void setResult(Map<Field, String> result) {
        this.result = result;
    }

    public List<String> getErrorReason() {
        return errorReason;
    }

    public void setErrorReason(List<String> errorReason) {
        this.errorReason = errorReason;
    }
}
