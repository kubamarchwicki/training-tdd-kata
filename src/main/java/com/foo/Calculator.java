package com.foo;

import java.util.Arrays;

public class Calculator {
    public static Integer add(String input) {
        if (input == null || "".equals(input.trim())) {
            return 0;
        }

//        return addImperative(input);
        return addFunctional(input);
    }

    private static Integer addImperative(String input) {
        final String delimiter = ",";

        final String[] el = input.split(delimiter);
        int sum = 0;
        for (String e: el) {
            sum += Integer.parseInt(e);
        }

        return sum;
    }

    private static Integer addFunctional(String input) {
        final String delimiter = ",";

        return Arrays.stream(input.split(delimiter))
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
