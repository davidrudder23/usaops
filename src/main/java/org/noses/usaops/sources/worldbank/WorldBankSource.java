package org.noses.usaops.sources.worldbank;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import org.noses.usaops.sources.usafacts.RetirementSavings;
import org.noses.usaops.sources.zipfile.ZipFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class WorldBankSource {

    @Autowired
    ZipFileReader zipFileReader;

    String fileNameRegex = "^API_.*.csv$";

    public List<DeathRates> getDeathRates() {

        try {
            List<CSVRecord> csvRecords = zipFileReader.getCSVRecords("http://api.worldbank.org/v2/en/indicator/SP.DYN.CDRT.IN?downloadformat=csv", fileNameRegex);
            log.info("death rate records={}", csvRecords);

            List<DeathRates> deathRatesList = new ArrayList<>();

            for (CSVRecord csvRecord : csvRecords) {

                if (csvRecord.get(0).equalsIgnoreCase("United States")) {
                    CSVRecord yearList = csvRecords.get(2);

                    for (int yearCol = 4; yearCol < yearList.size(); yearCol++) {
                        try {
                            int year = Integer.parseInt(yearList.get(yearCol));

                            DeathRates deathRates = new DeathRates();
                            deathRates.setYear(year);
                            deathRates.setDate(new Date(year-1900, 0, 1));
                            deathRates.setRate(new BigDecimal(cleanUp(csvRecord.get(yearCol))));

                            deathRatesList.add(deathRates);
                        } catch (NumberFormatException exc) {
                            log.warn("Problem parsing a retirement savings record, will not add record {}", yearCol);
                        }
                    }
                }
            }

            return deathRatesList;

        } catch (Exception anyExc) {
            log.error("Could not load death rates", anyExc);
        }

        return null;
    }

    public List<FertilityRates> getFertilityRates() {

        try {
            List<CSVRecord> csvRecords = zipFileReader.getCSVRecords("http://api.worldbank.org/v2/en/indicator/SP.DYN.TFRT.IN?downloadformat=csv", fileNameRegex);
            log.info("fertility rate records={}", csvRecords);

            List<FertilityRates> fertilityRatesList = new ArrayList<>();

            for (CSVRecord csvRecord : csvRecords) {

                if (csvRecord.get(0).equalsIgnoreCase("United States")) {
                    CSVRecord yearList = csvRecords.get(2);

                    for (int yearCol = 4; yearCol < yearList.size(); yearCol++) {
                        try {
                            int year = Integer.parseInt(yearList.get(yearCol));

                            FertilityRates fertilityRates = new FertilityRates();
                            fertilityRates.setYear(year);
                            fertilityRates.setRate(new BigDecimal(cleanUp(csvRecord.get(yearCol))));
                            fertilityRates.setDate(new Date(year-1900, 0, 1));

                            fertilityRatesList.add(fertilityRates);
                        } catch (NumberFormatException exc) {
                            log.warn("Problem parsing a retirement savings record, will not add record {}", yearCol);
                        }
                    }
                }
            }

            return fertilityRatesList;

        } catch (Exception anyExc) {
            log.error("Could not load death rates", anyExc);
        }

        return null;
    }

    public List<SuicideRates> getSuicideRates() {

        try {
            List<CSVRecord> csvRecords = zipFileReader.getCSVRecords("http://api.worldbank.org/v2/en/indicator/SH.STA.SUIC.P5?downloadformat=csv", fileNameRegex);
            log.info("fertility rate records={}", csvRecords);

            List<SuicideRates> suicideRatesList = new ArrayList<>();

            for (CSVRecord csvRecord : csvRecords) {

                if (csvRecord.get(0).equalsIgnoreCase("United States")) {
                    CSVRecord yearList = csvRecords.get(2);

                    for (int yearCol = 4; yearCol < yearList.size(); yearCol++) {
                        try {
                            int year = Integer.parseInt(yearList.get(yearCol));

                            SuicideRates suicideRates = new SuicideRates();
                            suicideRates.setYear(year);
                            suicideRates.setRate(new BigDecimal(cleanUp(csvRecord.get(yearCol))));
                            suicideRates.setDate(new Date(year-1900, 0, 1));

                            suicideRatesList.add(suicideRates);
                        } catch (NumberFormatException exc) {
                            log.warn("Problem parsing a retirement savings record, will not add record {}", yearCol);
                        }
                    }
                }
            }

            return suicideRatesList;

        } catch (Exception anyExc) {
            log.error("Could not load death rates", anyExc);
        }

        return null;
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
