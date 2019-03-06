package com.alimmit;

import com.alimmit.query.FdicQuery;

public enum Endpoint {
    Institution("/institutions", "NAME", FdicQuery.SortOrder.ASC),
    Location("/locations", "NAME", FdicQuery.SortOrder.ASC);

    private final String apiName;
    private final String defaultSortBy;
    private final FdicQuery.SortOrder defaultSortOrder;

    Endpoint(final String apiName, final String defaultSortBy, final FdicQuery.SortOrder defaultSortOrder) {
        this.apiName = apiName;
        this.defaultSortBy = defaultSortBy;
        this.defaultSortOrder = defaultSortOrder;
    }

    public String getApiName() {
        return apiName;
    }

    public String getDefaultSortBy() {
        return defaultSortBy;
    }

    public FdicQuery.SortOrder getDefaultSortOrder() {
        return defaultSortOrder;
    }
}
