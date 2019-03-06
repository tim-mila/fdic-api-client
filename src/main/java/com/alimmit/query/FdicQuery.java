package com.alimmit.query;

import com.alimmit.Endpoint;
import org.apache.commons.lang3.StringUtils;

import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

public final class FdicQuery {

    public enum SortOrder { ASC, DESC }

    private final Endpoint endpoint;
    private final List<Filter> filters;
    private final List<String> fields;
    private int offset;
    private int limit;
    private String sortBy;
    private SortOrder sortOrder;

    public static FdicQuery from(final Endpoint endpoint) {
        return new FdicQuery(endpoint);
    }

    private FdicQuery(final Endpoint endpoint) {
        this.endpoint = endpoint;
        this.filters = new ArrayList<>();
        this.fields = new ArrayList<>();
        this.offset = 0;
        this.limit = 10;
    }

    public FdicQuery filter(final Filter filter) {
        filters.add(filter);
        return this;
    }

    public FdicQuery field(final String field) {
        fields.add(field);
        return this;
    }

    public FdicQuery fields(final String...fields) {
        this.fields.addAll(Arrays.asList(fields));
        return this;
    }

    public FdicQuery offset(final int offset) {
        this.offset = offset;
        return this;
    }

    public FdicQuery limit(final int limit) {
        this.limit = limit;
        return this;
    }

    public FdicQuery sortBy(final String sortBy) {
        this.sortBy = sortBy;
        return this;
    }

    public FdicQuery sortOrder(final SortOrder sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    @Override
    public String toString() {
        try {
            final Map<String, String> parameters = new HashMap<>();
            if (!filters.isEmpty()) {
                parameters.put("filters", URLEncoder.encode(StringUtils.join(filters, " AND "), "UTF-8"));
            }
            if (!fields.isEmpty()) {
                parameters.put("fields", StringUtils.join(fields, ','));
            }
            parameters.put("limit", String.valueOf(limit));
            parameters.put("offset", String.valueOf(offset));

            if (sortBy != null) {
                parameters.put("sortBy", sortBy);
            }
            if (sortOrder != null) {
                parameters.put("sortOrder", sortOrder.name());
            }
            parameters.put("format", "json");
            parameters.put("download", "false");

            final String queryString = parameters.entrySet().stream().map((e) -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining("&"));
            return endpoint.getApiName() + "?" + queryString;
        }
        catch(Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
