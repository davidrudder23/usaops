package org.noses.usaops.sources.health;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class SuicideSourceTest {

    @Test
    public void testSuicideSource() {
        SuicidesSource suicidesSource = new SuicidesSource();
        log.info("suicides={}", suicidesSource.getSuicideData());
    }
}
