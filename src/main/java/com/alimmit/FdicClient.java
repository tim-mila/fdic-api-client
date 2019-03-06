package com.alimmit;

import com.alimmit.query.FdicQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class FdicClient {

    private static final Log LOG = LogFactory.getLog(FdicClient.class);
    private static final String HOST = "https://banks.data.fdic.gov";
    private static final String HOST_API = HOST + "/api";

    public String query(final FdicQuery query) {
        try {
            final HttpClient client = HttpClientBuilder.create().build();
            final String url = query.toString();
            LOG.info("api endpoint: " + url);
            final HttpGet get = new HttpGet(HOST_API + url);
            final HttpResponse response = client.execute(get);
            return new BufferedReader(new InputStreamReader(response.getEntity().getContent())).lines().collect(Collectors.joining());
        }
        catch (IOException e) {
            LOG.error(e.getMessage());
            throw new FdicClientException(e);
        }
    }
}
