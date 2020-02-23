package org.noses.usaops.sources.cpj;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class CPJService {

    @Autowired
    CPJSource cpjSource;

    @Autowired
    JournalistsKilledRepository journalistsKilledRepository;

    public void loadNumJournalistsKilledInUS() {
        try {
            List<JournalistsKilled> journalistsKilledList = cpjSource.getUSAJournalistsKilled();

            journalistsKilledRepository.save(journalistsKilledList);
            journalistsKilledRepository.flush();

        } catch (Exception e) {
            log.error("could not load number of journalists killed from cpj", e);
        }
    }

    public void loadNumJournalistsKilledInWorld() {
        try {
            List<JournalistsKilled> journalistsKilledList = cpjSource.getWorldJournalistsKilled();

            journalistsKilledRepository.save(journalistsKilledList);
            journalistsKilledRepository.flush();

        } catch (Exception e) {
            log.error("could not load number of journalists killed from cpj", e);
        }
    }

}
