package org.noses.usaops.sources.cpj;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

public class CPJSourceTest {

    @Test
    public void testNumJournalistsKilledInUS() throws Exception {
        CPJSource cpjSource = new CPJSource();
        List<JournalistsKilled> journalistsKilledList = cpjSource.getUSAJournalistsKilled();

        assertNotNull(journalistsKilledList);
        assertTrue(journalistsKilledList.size()>0);
    }
}
