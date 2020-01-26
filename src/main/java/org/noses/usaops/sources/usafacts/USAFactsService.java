package org.noses.usaops.sources.usafacts;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class USAFactsService {
    @Autowired
    RetirementSavingsRepository retirementSavingsRepository;

    public void loadUSAFacts() {
        try {
            RetirementSavingsSource retirementSavingsSource = new RetirementSavingsSource();
            List<RetirementSavings> retirementSavingsList = retirementSavingsSource.getData();

            for (RetirementSavings retirementSavings: retirementSavingsList) {
                retirementSavingsRepository.save(retirementSavings);
            }
        } catch (IOException ioExc) {
            log.error("Could not load Retirement Savings", ioExc);
        }
    }
}
