package org.noses.usaops.sources.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SuicidesService {
    @Autowired
    SuicidesRepository suicidesRepository;

    @Autowired SuicidesSource suicidesSource;

    public List<Suicides> loadSuicides() {
        List<Suicides> suicides = suicidesSource.getSuicideData();

        suicidesRepository.save(suicides);
        suicidesRepository.flush();

        return suicides;
    }
}
