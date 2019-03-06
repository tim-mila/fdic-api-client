package com.alimmit.query;

import java.util.Arrays;

public interface Filter {

    static Filter value(final String key, final String value) {
        return new Value(key, value);
    }

    static Filter or(final Filter...filters) {
        return new Or(Arrays.asList(filters));
    }

    static Filter and(final Filter...filters) {
        return new And(Arrays.asList(filters));
    }
}
