package org.noses.usaops.sources.stlouisfed;

import org.junit.Assert;
import org.junit.Test;
import org.noses.usaops.sources.stlousifed.ManufacturingEmployment;
import org.noses.usaops.sources.stlousifed.StLouisFedSource;
import org.noses.usaops.sources.worldbank.DeathRates;
import org.noses.usaops.sources.worldbank.FertilityRates;
import org.noses.usaops.sources.worldbank.WorldBankSource;
import org.noses.usaops.sources.zipfile.ZipFileReader;

import java.util.List;

public class StLouisFedSourceTest {

    @Test
    public void testDeathRates() {
        StLouisFedSource stLouisFedSource = new StLouisFedSource();
        List<ManufacturingEmployment> manufacturingEmploymentList = stLouisFedSource.getManufacturingEmployment();

        Assert.assertNotNull(manufacturingEmploymentList);
    }

}
