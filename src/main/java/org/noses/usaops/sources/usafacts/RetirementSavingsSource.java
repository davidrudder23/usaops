package org.noses.usaops.sources.usafacts;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class RetirementSavingsSource extends USAFactsCSVSource<RetirementSavings> {

    String url = "https://usafacts.org/download/topics?id=73&adjustment=inflation&filename=retirement-savings";

    @Override
    public List<RetirementSavings> getData() throws IOException {
        List<CSVRecord> csvRecords = getCSVRecords(url);
        List<RetirementSavings> retirementSavingsList = new ArrayList<RetirementSavings>();

        int yearOffset = 0;
        try {
            while ((yearOffset+1)<csvRecords.get(1).size() && (!StringUtils.isEmpty(csvRecords.get(1).get(yearOffset + 1)))) {
                int yearCol = yearOffset + 1;
                long year = Long.parseLong(csvRecords.get(1).get(yearCol));

                RetirementSavings retirementSavings = new RetirementSavings();
                retirementSavings.setYear(year);
                retirementSavings.setContributions401k(new BigDecimal(cleanUp(csvRecords.get(2).get(yearCol))));
                retirementSavings.setAssets401k(new BigDecimal(cleanUp(csvRecords.get(4).get(yearCol))));
                retirementSavings.setParticipants401k(new BigInteger(cleanUp(csvRecords.get(13).get(yearCol))));

                yearOffset++;

                retirementSavingsList.add(retirementSavings);
            }
        } catch (NumberFormatException exc) {
            log.warn("Problem parsing a retirement savings record, will not add record {}", exc, csvRecords.get(yearOffset+1));
        }

        log.debug("retirement list = {}", retirementSavingsList);
        return retirementSavingsList;
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

