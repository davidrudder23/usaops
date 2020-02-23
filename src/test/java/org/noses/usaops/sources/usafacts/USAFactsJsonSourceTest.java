package org.noses.usaops.sources.usafacts;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

public class USAFactsJsonSourceTest {

    @Test
    public void testGovernmentEmployment() {
        USAFactsJsonSource usaFactsJsonSource = new USAFactsJsonSource();
        List<GovernmentEmployment> governmentEmploymentList = usaFactsJsonSource.getGovernmentEmployment();

        assertNotNull(governmentEmploymentList);
        assertTrue(governmentEmploymentList.size()>0);
    }
}
