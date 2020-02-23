package org.noses.usaops.sources.worldbank;

import org.junit.Assert;
import org.junit.Test;
import org.noses.usaops.sources.zipfile.ZipFileReader;

import java.util.List;

public class WorldBankSourceTest {

    @Test
    public void testDeathRates() {
        WorldBankSource worldBankSource = new WorldBankSource();
        worldBankSource.zipFileReader = new ZipFileReader();
        List<DeathRates> deathRatesList = worldBankSource.getDeathRates();

        Assert.assertNotNull(deathRatesList);
    }

    @Test
    public void testFertilityRates() {
        WorldBankSource worldBankSource = new WorldBankSource();
        worldBankSource.zipFileReader = new ZipFileReader();
        List<FertilityRates> fertilityRatesList = worldBankSource.getFertilityRates();

        Assert.assertNotNull(fertilityRatesList);
    }
}
