package org.noses.usaops.sources.cpj;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CPJSource {

    private ObjectMapper objectMapper;
    CloseableHttpClient client;

    public CPJSource() {
        objectMapper = new ObjectMapper();
        client = HttpClients.createDefault();
    }

    public List<JournalistsKilled> getUSAJournalistsKilled() throws IOException {
        // From https://cpj.org/data/killed/?status=Killed&motiveConfirmed%5B%5D=Confirmed&motiveUnconfirmed%5B%5D=Unconfirmed&type%5B%5D=Journalist&type%5B%5D=Media%20Worker&cc_fips%5B%5D=US&start_year=2001&end_year=2020&group_by=year
        String url = "https://cpj.org/api/datamanager/reports/entries?group(year)&includes=Year,%27Motive%20Confirmed%27,%27Motive%20Unconfirmed%27,%27Media%20Worker%27&as(year,%20Year)&as(sum(if(eq(type,%27Media%20Worker%27),1,0)),%27Media%20Worker%27)&as(sum(if(and(eq(motiveConfirmed,Confirmed),eq(type,Journalist)),1,0)),%27Motive%20Confirmed%27)&as(sum(if(eq(motiveConfirmed,Unconfirmed),1,0)),%27Motive%20Unconfirmed%27)&or(eq(type,%20%27Media%20Worker%27),%20ne(motiveConfirmed,%20null))&order=-year&in(status,%27Killed%27)&or(eq(type,%22media%20worker%22),in(motiveConfirmed,%27Confirmed%27,%27Unconfirmed%27))&in(type,%27Journalist%27,%27Media%20Worker%27)&in(cc_fips,%27US%27)&ge(year,2001)&le(year,2020)";

        HttpGet httpGet = new HttpGet(url);
        ResponseHandler<String> handler = new BasicResponseHandler();

        HttpResponse response = client.execute(httpGet);
        String dataResponse = handler.handleResponse(response);

        List<JournalistsKilledDTO> journalistsKilledDTOList = Arrays.asList(objectMapper.readValue(dataResponse, JournalistsKilledDTO[].class));

        List<JournalistsKilled> journalistsKilledList = journalistsKilledDTOList.stream()
                .map(j->{
                    JournalistsKilled journalistsKilled = new JournalistsKilled();
                    journalistsKilled.setYear(Integer.parseInt(cleanUp(j.getYear())));
                    journalistsKilled.setLocation("US");
                    journalistsKilled.setNumKilled(j.getMediaWorker()+j.getMotiveConfirmed()+j.getMotiveUnconfirmed());
                    journalistsKilled.setDate(new Date(journalistsKilled.getYear()-1900, 0, 0));

                    return journalistsKilled;
                }).collect(Collectors.toList());

        return journalistsKilledList;
    }

    public List<JournalistsKilled> getWorldJournalistsKilled() throws IOException {
        // From https://cpj.org/data/killed/?status=Killed&motiveConfirmed%5B%5D=Confirmed&motiveUnconfirmed%5B%5D=Unconfirmed&type%5B%5D=Journalist&type%5B%5D=Media%20Worker&cc_fips%5B%5D=US&start_year=2001&end_year=2020&group_by=year
        String url = "https://cpj.org/api/datamanager/reports/entries?group(year)&includes=Year,%27Motive%20Confirmed%27,%27Motive%20Unconfirmed%27,%27Media%20Worker%27&as(year,%20Year)&as(sum(if(eq(type,%27Media%20Worker%27),1,0)),%27Media%20Worker%27)&as(sum(if(and(eq(motiveConfirmed,Confirmed),eq(type,Journalist)),1,0)),%27Motive%20Confirmed%27)&as(sum(if(eq(motiveConfirmed,Unconfirmed),1,0)),%27Motive%20Unconfirmed%27)&or(eq(type,%20%27Media%20Worker%27),%20ne(motiveConfirmed,%20null))&order=-year&in(status,%27Killed%27)&or(eq(type,%22media%20worker%22),in(motiveConfirmed,%27Confirmed%27,%27Unconfirmed%27))&in(type,%27Journalist%27,%27Media%20Worker%27)&in(cc_fips,%27US%27)&ge(year,2001)&le(year,2020)";

        HttpGet httpGet = new HttpGet(url);
        ResponseHandler<String> handler = new BasicResponseHandler();

        HttpResponse response = client.execute(httpGet);
        String dataResponse = handler.handleResponse(response);

        List<JournalistsKilledDTO> journalistsKilledDTOList = Arrays.asList(objectMapper.readValue(dataResponse, JournalistsKilledDTO[].class));

        List<JournalistsKilled> journalistsKilledList = journalistsKilledDTOList.stream()
                .map(j->{
                    JournalistsKilled journalistsKilled = new JournalistsKilled();
                    journalistsKilled.setYear(Integer.parseInt(cleanUp(j.getYear())));
                    journalistsKilled.setLocation("World");
                    journalistsKilled.setNumKilled(j.getMediaWorker()+j.getMotiveConfirmed()+j.getMotiveUnconfirmed());
                    journalistsKilled.setDate(new Date(journalistsKilled.getYear()-1900, 0, 0));

                    return journalistsKilled;
                }).collect(Collectors.toList());

        return journalistsKilledList;
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
