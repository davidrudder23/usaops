package org.noses.usaops.sources.health;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class SuicidesSource {

    private ObjectMapper objectMapper;
    CloseableHttpClient client;

    protected SuicidesSource() {
        objectMapper = new ObjectMapper();
        client = HttpClients.createDefault();
    }


    public List<Suicides> getSuicideData() {
        try {
            String url = "https://afsp.org/wp-content/themes/afsp/stats/suicide-state-2017.csv";

            List<CSVRecord> csvRecords = getCSVRecords(url);
            List<Suicides> suicidesList = new ArrayList<Suicides>();

            for (CSVRecord record: csvRecords) {
                log.info("suicide csv record={}", record);
                if ("US Average".equalsIgnoreCase(record.get(0))) {
                    int year = Integer.parseInt(record.get(2));
                    BigDecimal rate = new BigDecimal(record.get(3));

                    Suicides suicides = new Suicides();
                    suicides.setYear(year);
                    suicides.setRate(rate);
                    suicides.setDate(new Date(year-1900, 0, 1));

                    suicidesList.add(suicides);

                    log.info("Got US Average suicides for {} = {}", year, rate);
                }
            }
            return suicidesList;

        } catch (Exception anyExc) {
            log.error("Could not load suicide data", anyExc);

            return null;
        }
    }

    protected List<CSVRecord> getCSVRecords(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        ResponseHandler<String> handler = new BasicResponseHandler();

        HttpResponse response = client.execute(httpGet);
        String dataResponse = handler.handleResponse(response);

        CSVParser parser = new CSVParser(new StringReader(dataResponse), CSVFormat.DEFAULT);
        return parser.getRecords();
    }
}
