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
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class OpiodOverdosesSource {

    private ObjectMapper objectMapper;
    CloseableHttpClient client;

    protected OpiodOverdosesSource() {
        objectMapper = new ObjectMapper();
        client = HttpClients.createDefault();
    }

    public List<OpiodOverdoses> getData() {
        try {
            String url = "https://data.cdc.gov/api/views/xkb8-kh2a/rows.csv";

            List<CSVRecord> csvRecords = getCSVRecords(url);
            List<OpiodOverdoses> opiodOverdosesList = new ArrayList<OpiodOverdoses>();

            for (CSVRecord record : csvRecords) {

                // Strip out header row
                if (record.get(0).equalsIgnoreCase("state")) {
                    continue;
                }

                if (!(record.get(4).toLowerCase().contains("heroin")) ||
                        record.get(4).toLowerCase().contains("opioid"))  {
                    continue;
                }

                if (StringUtils.isEmpty(record.get(5))) {
                    continue;
                }

                int year = Integer.parseInt(record.get(1));
                BigDecimal rate = new BigDecimal(record.get(5));
                String type = record.get(2);

                OpiodOverdoses opiodOverdoses = new OpiodOverdoses();
                opiodOverdoses.setYear(year);
                opiodOverdoses.setRate(rate);
                opiodOverdoses.setType(type);
                opiodOverdosesList.add(opiodOverdoses);
                log.info("Got opiod overdoses for {} = {}", year, opiodOverdoses);
            }

            return opiodOverdosesList;

        } catch (Exception anyExc) {
            log.error("Could not load opiod overdose data", anyExc);

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
