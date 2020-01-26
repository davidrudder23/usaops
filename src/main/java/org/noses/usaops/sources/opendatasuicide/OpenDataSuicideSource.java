package org.noses.usaops.sources.opendatasuicide;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

@Slf4j
public class OpenDataSuicideSource {

    private ObjectMapper objectMapper;
    CloseableHttpClient client;

    public OpenDataSuicideSource() {
        objectMapper = new ObjectMapper();
        client = HttpClients.createDefault();
    }

    public OpenDataSuicide getData() throws IOException {
        HttpGet httpGet = new HttpGet("https://opendata.maryland.gov/api/views/8kn6-62x4/rows.json?accessType=DOWNLOAD");

        ResponseHandler<String> handler = new BasicResponseHandler();

        HttpResponse response = client.execute(httpGet);
        String dataResponse = handler.handleResponse(response);
        log.info("DataResponse={}", dataResponse);

        OpenDataSuicide openDataSuicide = new ObjectMapper().readValue(dataResponse, OpenDataSuicide.class);

        log.info("open data suicide={}", openDataSuicide);

        return openDataSuicide;

    }
}
