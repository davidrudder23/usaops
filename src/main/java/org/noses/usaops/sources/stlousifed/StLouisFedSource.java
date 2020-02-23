package org.noses.usaops.sources.stlousifed;

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
import org.noses.usaops.sources.health.Suicides;
import org.noses.usaops.sources.worldbank.DeathRates;
import org.noses.usaops.sources.worldbank.FertilityRates;
import org.noses.usaops.sources.zipfile.ZipFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class StLouisFedSource {

    private ObjectMapper objectMapper;
    CloseableHttpClient client;

    public StLouisFedSource() {
        objectMapper = new ObjectMapper();
        client = HttpClients.createDefault();
    }

    public List<ManufacturingEmployment> getManufacturingEmployment() {

        try {

            String url = "https://fred.stlouisfed.org/graph/fredgraph.csv?ts=12&tts=12&nt=0&thu=0&trc=0&id=MANEMP&cosd=1939-01-01&coed=2080-01-01&mw=3&lw=2&ost=-99999&oet=99999&mma=0&fml=a&fq=Monthly";

            List<CSVRecord> csvRecords = getCSVRecords(url);
            List<ManufacturingEmployment> manufacturingEmploymentList = new ArrayList<ManufacturingEmployment>();

            for (CSVRecord record : csvRecords) {
                try {
                    log.info("manufacturing employment csv record={}", record);

                    String yearString = record.get(0);
                    Date yearDate =new SimpleDateFormat("yyyy-MM-dd").parse(yearString);
                    int year = yearDate.getYear()+1900;
                    BigInteger amount = new BigInteger(record.get(1));

                    ManufacturingEmployment manufacturingEmployment = new ManufacturingEmployment();
                    manufacturingEmployment.setYear(year);
                    manufacturingEmployment.setAmount(amount);
                    manufacturingEmployment.setDate(yearDate);

                    manufacturingEmploymentList.add(manufacturingEmployment);

                    log.info("Got US manufacturing for {} = {}", year, amount);
                } catch (ParseException |NumberFormatException nfExc) {
                    log.error("Not loading manufacturing record");
                }
            }
            return manufacturingEmploymentList;

        } catch (Exception anyExc) {
            log.error("Could not load death rates", anyExc);
        }

        return null;
    }

    public List<TaxReceipts> getTaxReceipts() {

        try {

            String url = "https://fred.stlouisfed.org/graph/fredgraph.csv?bgcolor=%23e1e9f0&chart_type=line&drp=0&fo=open%20sans&graph_bgcolor=%23ffffff&height=450&mode=fred&recession_bars=on&txtcolor=%23444444&ts=12&tts=12&width=1168&nt=0&thu=0&trc=0&show_legend=yes&show_axis_titles=yes&show_tooltip=yes&id=W006RC1Q027SBEA&scale=left&cosd=1947-01-01&coed=2019-07-01&line_color=%234572a7&link_values=false&line_style=solid&mark_type=none&mw=3&lw=2&ost=-99999&oet=99999&mma=0&fml=a&fq=Quarterly&fam=avg&fgst=lin&fgsnd=2009-06-01&line_index=1&transformation=lin&vintage_date=2020-02-14&revision_date=2020-02-14&nd=1947-01-01";

            List<CSVRecord> csvRecords = getCSVRecords(url);
            List<TaxReceipts> taxReceiptsList = new ArrayList<TaxReceipts>();

            for (CSVRecord record : csvRecords) {
                try {
                    log.info("manufacturing employment csv record={}", record);

                    String yearString = record.get(0);
                    Date yearDate =new SimpleDateFormat("yyyy-MM-dd").parse(yearString);
                    int year = yearDate.getYear()+1900;
                    BigDecimal amount = new BigDecimal(record.get(1));

                    TaxReceipts taxReceipts = new TaxReceipts();
                    taxReceipts.setYear(year);
                    taxReceipts.setAmount(amount);
                    taxReceipts.setDate(yearDate);

                    taxReceiptsList.add(taxReceipts);

                    log.info("Got US manufacturing for {} = {}", year, amount);
                } catch (ParseException |NumberFormatException nfExc) {
                    log.error("Not loading manufacturing record");
                }
            }
            return taxReceiptsList;

        } catch (Exception anyExc) {
            log.error("Could not load death rates", anyExc);
        }

        return null;
    }

    public List<GovernmentSpending> getGovernmentSpending() {

        try {

            String url = "https://fred.stlouisfed.org/graph/fredgraph.csv?bgcolor=%23e1e9f0&chart_type=line&drp=0&fo=open%20sans&graph_bgcolor=%23ffffff&height=450&mode=fred&recession_bars=on&txtcolor=%23444444&ts=12&tts=12&width=1168&nt=0&thu=0&trc=0&show_legend=yes&show_axis_titles=yes&show_tooltip=yes&id=W068RCQ027SBEA&scale=left&cosd=1960-01-01&coed=2019-10-01&line_color=%234572a7&link_values=false&line_style=solid&mark_type=none&mw=3&lw=2&ost=-99999&oet=99999&mma=0&fml=a&fq=Quarterly&fam=avg&fgst=lin&fgsnd=2009-06-01&line_index=1&transformation=lin&vintage_date=2020-02-14&revision_date=2020-02-14&nd=1960-01-01";

            List<CSVRecord> csvRecords = getCSVRecords(url);
            List<GovernmentSpending> governmentSpendingList = new ArrayList<GovernmentSpending>();

            for (CSVRecord record : csvRecords) {
                try {
                    log.info("manufacturing employment csv record={}", record);

                    String yearString = record.get(0);
                    Date yearDate =new SimpleDateFormat("yyyy-MM-dd").parse(yearString);
                    int year = yearDate.getYear()+1900;
                    BigDecimal amount = new BigDecimal(record.get(1));

                    GovernmentSpending governmentSpending = new GovernmentSpending();
                    governmentSpending.setYear(year);
                    governmentSpending.setAmount(amount);
                    governmentSpending.setDate(yearDate);

                    governmentSpendingList.add(governmentSpending);

                    log.info("Got US spending for {} = {}", year, amount);
                } catch (ParseException |NumberFormatException nfExc) {
                    log.error("Not loading government spending");
                }
            }
            return governmentSpendingList;

        } catch (Exception anyExc) {
            log.error("Could not load government spending", anyExc);
        }

        return null;
    }

    protected List<CSVRecord> getCSVRecords(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        ResponseHandler<String> handler = new BasicResponseHandler();

        HttpResponse response = client.execute(httpGet);
        String dataResponse = handler.handleResponse(response);

        CSVParser parser = new CSVParser(new StringReader(dataResponse), CSVFormat.DEFAULT);
        return parser.getRecords();
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
