package org.example.field;

public interface Field {

    String parseValue(String inputValue);

    int getOrder();

    String getDisplayName();
}
