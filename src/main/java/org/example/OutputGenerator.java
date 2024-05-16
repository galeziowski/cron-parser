package org.example;

import org.example.field.Field;
import org.example.format.ParsingResult;

import java.util.Comparator;
import java.util.Map;

public class OutputGenerator {

    static Comparator<Map.Entry<Field, String>> byOrder = Comparator.comparing(entry -> entry.getKey().getOrder());

    public static void printOutput(ParsingResult parsingResult) {

        if (!parsingResult.getErrorReason().isEmpty()) {
            parsingResult.getErrorReason().forEach(System.out::println);
        } else if (!parsingResult.getResult().isEmpty()) {
            parsingResult.getResult().entrySet()
                    .stream()
                    .sorted(byOrder)
                    .forEach(it -> {
                        System.out.printf("%-13s %s%n", it.getKey().getDisplayName(), it.getValue());
                    });
        }



    }

}
