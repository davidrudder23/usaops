package org.noses.usaops.sources.usafacts;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.noses.usaops.sources.opendatasuicide.OpenDataSuicide;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public abstract class USAFactsCSVSource<T> {


    private ObjectMapper objectMapper;
    CloseableHttpClient client;

    protected USAFactsCSVSource() {
        objectMapper = new ObjectMapper();
        client = HttpClients.createDefault();
    }

    public abstract List<T> getData() throws IOException;

    protected List<CSVRecord> getCSVRecords(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        ResponseHandler<String> handler = new BasicResponseHandler();

        HttpResponse response = client.execute(httpGet);
        String dataResponse = handler.handleResponse(response);

        CSVParser parser = new CSVParser(new StringReader(dataResponse), CSVFormat.DEFAULT);
        return parser.getRecords();
    }
}
