package org.noses.usaops.sources.usafacts;

import lombok.extern.slf4j.Slf4j;
import org.noses.usaops.sources.cpj.JournalistsKilled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class USAFactsService {
    @Autowired
    RetirementSavingsRepository retirementSavingsRepository;

    @Autowired
    HealthcareExpensesRepository healthcareExpensesRepository;

    @Autowired
    USAFactsJsonSource usaFactsJsonSource;

    @Autowired
    GovernmentEmploymentRepository governmentEmploymentRepository;

    public void loadUSAFacts() {
        try {
            RetirementSavingsSource retirementSavingsSource = new RetirementSavingsSource();
            List<RetirementSavings> retirementSavingsList = retirementSavingsSource.getData();

            retirementSavingsRepository.save(retirementSavingsList);
            retirementSavingsRepository.flush();

        } catch (IOException ioExc) {
            log.error("Could not load RetirementSavings", ioExc);
        }

        try {
            HealthcareExpensesSource healthcareExpensesSource = new HealthcareExpensesSource();
            List<HealthcareExpenses> healthcareExpensesList = healthcareExpensesSource.getData();

            healthcareExpensesRepository.save(healthcareExpensesList);
            healthcareExpensesRepository.flush();
        } catch (IOException ioExc) {
            log.error("Could not load HealthcareExpenses", ioExc);
        }

    }

    public void loadGovernmentEmployment() {
        try {
            List<GovernmentEmployment> governmentEmploymentList = usaFactsJsonSource.getGovernmentEmployment();


            governmentEmploymentRepository.save(governmentEmploymentList);
            governmentEmploymentRepository.flush();

        } catch (Exception e) {
            log.error("could not load government employment from usafacts", e);
        }
    }
}
