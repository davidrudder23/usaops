package org.noses.usaops.sources.worldbank;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class WorldBankService {

    @Autowired
    DeathRatesRepository deathRatesRepository;

    @Autowired
    FertilityRatesRepository fertilityRatesRepository;

    @Autowired
    SuicideRatesRepository suicideRatesRepository;

    @Autowired
    WorldBankSource worldBankSource;

    public List<DeathRates> loadDeathRates() {
        List<DeathRates> deathRatesList = worldBankSource.getDeathRates();

        deathRatesRepository.save(deathRatesList);
        deathRatesRepository.flush();
        return deathRatesList;
    }

    public List<FertilityRates> loadFertilityRates() {
        List<FertilityRates> fertilityRatesList = worldBankSource.getFertilityRates();

        log.info("fertility rates={}", fertilityRatesList);

        fertilityRatesRepository.save(fertilityRatesList);
        fertilityRatesRepository.flush();
        return fertilityRatesList;
    }


    public List<SuicideRates> loadSuicideRates() {
        List<SuicideRates> suicideRatesList = worldBankSource.getSuicideRates();

        log.info("suicide rates={}", suicideRatesList);

        suicideRatesRepository.save(suicideRatesList);
        suicideRatesRepository.flush();
        return suicideRatesList;
    }

}
