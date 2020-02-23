package org.noses.usaops.sources;

import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

@Ignore
public class BLSSourceTest {

    @Test
    public void testBLS() {
        try {
            new BLSSource().getData(Collections.singletonList("CMU1010000000000D"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
