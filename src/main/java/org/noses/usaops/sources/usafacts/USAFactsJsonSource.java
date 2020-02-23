package org.noses.usaops.sources.usafacts;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.noses.usaops.sources.cpj.JournalistsKilled;
import org.noses.usaops.sources.cpj.JournalistsKilledDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class USAFactsJsonSource {

    private ObjectMapper objectMapper;
    CloseableHttpClient client;

    public USAFactsJsonSource() {
        objectMapper = new ObjectMapper();
        client = HttpClients.createDefault();
    }


    public List<GovernmentEmployment> getGovernmentEmployment() {
        try {

            String url = "https://api.usafacts.org/api/v3/datasets?line_item_id=b807ddab-2931-4b88-961d-2cc3a1befb08&fips=US&gov_type=federal";

            HttpGet httpGet = new HttpGet(url);
            ResponseHandler<String> handler = new BasicResponseHandler();

            HttpResponse response = client.execute(httpGet);
            String dataResponse = handler.handleResponse(response);

            GovernmentEmploymentDTO governmentEmploymentDTO = objectMapper.readValue(dataResponse, GovernmentEmploymentDTO[].class)[0];

            List<GovernmentEmployment> governmentEmploymentList = governmentEmploymentDTO.getDataset().getData().stream()
                    .map(g -> {
                        GovernmentEmployment governmentEmployment = new GovernmentEmployment();
                        governmentEmployment.setYear(Integer.parseInt(cleanUp(g.getX())));
                        governmentEmployment.setAmount(g.getY());
                        governmentEmployment.setDate(new Date(governmentEmployment.getYear() - 1900, 0, 0));

                        return governmentEmployment;
                    }).collect(Collectors.toList());

            return governmentEmploymentList;
        } catch (Exception e) {
            log.error("Could not load government employment", e);
            return null;
        }
    }


    private String cleanUp(String input) {
        if (StringUtils.isEmpty(input)) {
            return "0";
        }

        if (input.equalsIgnoreCase("n/a")) {
            return "0";
        }

        return input;
    }
}
