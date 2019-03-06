package com.alimmit.query;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

class And implements Filter {

    private final List<Filter> filters;

    And(final List<Filter> filters) { this.filters = filters; }

    @Override
    public String toString() {
        return StringUtils.join(filters, " AND ");
    }
}
