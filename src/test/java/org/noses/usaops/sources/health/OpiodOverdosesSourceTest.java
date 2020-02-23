package org.noses.usaops.sources.health;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

public class OpiodOverdosesSourceTest {

    @Test
    public void testOpiodOverdoses() {
        OpiodOverdosesSource opiodOverdosesSource = new OpiodOverdosesSource();
        List<OpiodOverdoses> opiodOverdosesList = opiodOverdosesSource.getData();
        assertNotNull(opiodOverdosesList);
        assertTrue(opiodOverdosesList.size()>0);
    }
}
