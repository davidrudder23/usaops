package org.noses.usaops.sources.usafacts;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class RetirementSavingsSourceTest {

    @Test
    public void testRetirementSavingsSource() throws IOException  {
        RetirementSavingsSource retirementSavingsSource = new RetirementSavingsSource();
        List<RetirementSavings> retirementSavings = retirementSavingsSource.getData();

        assertNotNull(retirementSavings);
        assertTrue(retirementSavings.size()>1);
    }
}
