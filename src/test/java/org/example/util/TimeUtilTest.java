package org.example.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TimeUtilTest {
    /**
     * Method under test: {@link TimeUtil#getCurrentTime()}
     */
    @Test
    void testGetCurrentTime() {
        assertNotNull(TimeUtil.getCurrentTime());
    }
}
