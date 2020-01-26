package org.noses.usaops.sources;

import static org.junit.Assert.*;
import org.junit.Test;
import org.noses.usaops.sources.opendatasuicide.OpenDataSuicide;
import org.noses.usaops.sources.opendatasuicide.OpenDataSuicideSource;

import java.io.IOException;
import java.util.Collections;

public class OpenDataSuicideTest {

    @Test
    public void testOpenDataSuicide() {
        try {
            OpenDataSuicide openDataSuicide = new OpenDataSuicideSource().getData();
            assertNotNull(openDataSuicide);

            assertNotNull(openDataSuicide.getData());
            assertTrue(openDataSuicide.getData().size()>0);
            } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
