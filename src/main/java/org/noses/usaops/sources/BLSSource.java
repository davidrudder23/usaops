package org.noses.usaops.sources;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

@Component
@Slf4j
public class BLSSource {
    private ObjectMapper objectMapper;
    CloseableHttpClient client;

    public BLSSource() {
        objectMapper = new ObjectMapper();
        client = HttpClients.createDefault();
    }

    public void getData(List<String> series) throws IOException {
        HttpPost httpPost = new HttpPost("https://api.bls.gov/publicAPI/v2/timeseries/data/");

        Calendar calendar = Calendar.getInstance();
        int endYear  = calendar.get(Calendar.YEAR);
        int startYear = endYear - 10;

        String seriesAsString = objectMapper.writeValueAsString(new BLSSeries((String[])series.toArray(new String[0]),
                ""+startYear,
                ""+endYear));

        log.info(seriesAsString);
        StringEntity stringEntity = new StringEntity(seriesAsString);
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);

        ResponseHandler<String> handler = new BasicResponseHandler();

        HttpResponse response = client.execute(httpPost);
        String dataResponse = handler.handleResponse(response);
        log.info("DataResponse={}", dataResponse);

    }
}

@Data
@AllArgsConstructor
class BLSSeries {
    String[] seriesid;
    String startyear;
    String endyear;
}
