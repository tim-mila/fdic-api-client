package com.alimmit;

import com.alimmit.query.FdicQuery;
import com.alimmit.query.Filter;
import org.junit.Test;

public class FdicClientTest {

    @Test
    public void name() {
        System.out.println(FdicQuery.from(Endpoint.Institution).filter(Filter.value("NAME", "Wells*")).field("NAME").field("ZIP").sortBy("OFFICES").sortOrder(FdicQuery.SortOrder.ASC).toString());
        System.out.println(FdicQuery.from(Endpoint.Institution).filter(Filter.and(Filter.value("NAME", "Wells*"), Filter.value("ACTIVE", "1"))).field("NAME").field("ZIP").sortBy("OFFICES").sortOrder(FdicQuery.SortOrder.ASC).toString());
    }

    @Test
    public void query() {
        System.out.println(new FdicClient().query(FdicQuery.from(Endpoint.Institution).filter(Filter.and(Filter.value("NAME", "Wells*"), Filter.value("ACTIVE", "1"))).field("NAME").field("ZIP").sortBy("OFFICES").sortOrder(FdicQuery.SortOrder.ASC)));
    }
}