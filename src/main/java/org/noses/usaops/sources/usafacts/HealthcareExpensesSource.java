package org.noses.usaops.sources.usafacts;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class HealthcareExpensesSource extends USAFactsCSVSource<HealthcareExpenses> {

    String url = "https://usafacts.org/download/metrics?filename=national-spending-on-healthcare-goods-and-services&ids=32494&regions=US";

    @Override
    public List<HealthcareExpenses> getData() throws IOException {
        List<CSVRecord> csvRecords = getCSVRecords(url);

        log.info("healthcare records={}", csvRecords);
        List<HealthcareExpenses> healthcareExpensesList = new ArrayList<HealthcareExpenses>();

        int yearOffset = 0;
        try {
            while ((yearOffset+1)<csvRecords.get(1).size() && (!StringUtils.isEmpty(csvRecords.get(0).get(yearOffset + 1)))) {
                int yearCol = yearOffset + 1;
                long year = Long.parseLong(csvRecords.get(0).get(yearCol));

                HealthcareExpenses healthcareExpenses = new HealthcareExpenses();
                healthcareExpenses.setYear(year);
                healthcareExpenses.setSpending(new BigInteger(cleanUp(csvRecords.get(1).get(yearCol))));

                yearOffset++;

                healthcareExpensesList.add(healthcareExpenses);
            }
        } catch (NumberFormatException exc) {
            log.warn("Problem parsing a healthcare expenses record, will not add record", exc);
        }

        log.debug("healthcareExpensesList = {}", healthcareExpensesList);
        return healthcareExpensesList;
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

