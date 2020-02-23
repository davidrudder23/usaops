package org.noses.usaops.sources.usafacts;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class RetirementSavingsSourceTest {

    @Test
    @Ignore // 404 not found
    public void testRetirementSavingsSource() throws IOException  {
        RetirementSavingsSource retirementSavingsSource = new RetirementSavingsSource();
        List<RetirementSavings> retirementSavings = retirementSavingsSource.getData();

        assertNotNull(retirementSavings);
        assertTrue(retirementSavings.size()>1);
    }
}
