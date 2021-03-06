package com.alimmit.query;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

class Or implements Filter {

    private final List<Filter> filters;

    Or(final List<Filter> filters) { this.filters = filters; }

    @Override
    public String toString() {
        return StringUtils.join(filters, " OR ");
    } 
}
