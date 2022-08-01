package org.example.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StringUtilTest {
    /**
     * Method under test: {@link StringUtil#isExact6Digits(String)}
     */
    @Test
    void testIsExact6Digits() {
        assertFalse(StringUtil.isExact6Digits("Input"));
        assertTrue(StringUtil.isExact6Digits("999999"));
        assertTrue(StringUtil.isExact6Digits("424242"));
    }

    /**
     * Method under test: {@link StringUtil#isValidAccountNumber(String)}
     */
    @Test
    void testIsValidAccountNumber() {
        assertFalse(StringUtil.isValidAccountNumber("3"));
        assertFalse(StringUtil.isValidAccountNumber("foo"));
        assertFalse(StringUtil.isValidAccountNumber("9"));
        assertTrue(StringUtil.isValidAccountNumber("999999"));
        assertFalse(StringUtil.isValidAccountNumber("42"));
        assertFalse(StringUtil.isValidAccountNumber(""));
        assertFalse(StringUtil.isValidAccountNumber("33"));
        assertFalse(StringUtil.isValidAccountNumber("39"));
        assertFalse(StringUtil.isValidAccountNumber("3999999"));
        assertFalse(StringUtil.isValidAccountNumber("342"));
        assertFalse(StringUtil.isValidAccountNumber("93"));
        assertFalse(StringUtil.isValidAccountNumber("99"));
        assertFalse(StringUtil.isValidAccountNumber("9999999"));
        assertFalse(StringUtil.isValidAccountNumber("942"));
        assertFalse(StringUtil.isValidAccountNumber("9999993"));
        assertFalse(StringUtil.isValidAccountNumber("999999999999"));
        assertFalse(StringUtil.isValidAccountNumber("99999942"));
        assertFalse(StringUtil.isValidAccountNumber("423"));
        assertFalse(StringUtil.isValidAccountNumber("429"));
        assertFalse(StringUtil.isValidAccountNumber("4242"));
        assertFalse(StringUtil.isValidAccountNumber("333"));
        assertFalse(StringUtil.isValidAccountNumber("339"));
        assertFalse(StringUtil.isValidAccountNumber("3342"));
        assertFalse(StringUtil.isValidAccountNumber("393"));
        assertFalse(StringUtil.isValidAccountNumber("399"));
        assertFalse(StringUtil.isValidAccountNumber("42999999"));
        assertFalse(StringUtil.isValidAccountNumber("3942"));
        assertFalse(StringUtil.isValidAccountNumber("33999999"));
        assertFalse(StringUtil.isValidAccountNumber("39999999"));
        assertFalse(StringUtil.isValidAccountNumber("39999993"));
        assertFalse(StringUtil.isValidAccountNumber("3999999999999"));
        assertFalse(StringUtil.isValidAccountNumber("3423"));
        assertFalse(StringUtil.isValidAccountNumber("3429"));
        assertFalse(StringUtil.isValidAccountNumber("399999942"));
        assertFalse(StringUtil.isValidAccountNumber("34242"));
        assertFalse(StringUtil.isValidAccountNumber("933"));
        assertFalse(StringUtil.isValidAccountNumber("939"));
        assertFalse(StringUtil.isValidAccountNumber("9342"));
        assertFalse(StringUtil.isValidAccountNumber("993"));
        assertFalse(StringUtil.isValidAccountNumber("999"));
        assertFalse(StringUtil.isValidAccountNumber("9942"));
        assertFalse(StringUtil.isValidAccountNumber("342999999"));
        assertFalse(StringUtil.isValidAccountNumber("93999999"));
        assertFalse(StringUtil.isValidAccountNumber("9423"));
        assertFalse(StringUtil.isValidAccountNumber("9429"));
        assertFalse(StringUtil.isValidAccountNumber("99999999"));
        assertFalse(StringUtil.isValidAccountNumber("94242"));
        assertFalse(StringUtil.isValidAccountNumber("99999993"));
        assertFalse(StringUtil.isValidAccountNumber("9999999999999"));
        assertFalse(StringUtil.isValidAccountNumber("999999942"));
        assertFalse(StringUtil.isValidAccountNumber("942999999"));
        assertFalse(StringUtil.isValidAccountNumber("99999933"));
        assertFalse(StringUtil.isValidAccountNumber("99999939"));
        assertFalse(StringUtil.isValidAccountNumber("9999993999999"));
        assertFalse(StringUtil.isValidAccountNumber("999999342"));
        assertFalse(StringUtil.isValidAccountNumber("9999999999993"));
        assertFalse(StringUtil.isValidAccountNumber("999999999999999999"));
        assertFalse(StringUtil.isValidAccountNumber("99999999999942"));
        assertFalse(StringUtil.isValidAccountNumber("999999423"));
        assertFalse(StringUtil.isValidAccountNumber("999999429"));
        assertFalse(StringUtil.isValidAccountNumber("99999942999999"));
        assertFalse(StringUtil.isValidAccountNumber("9999994242"));
        assertFalse(StringUtil.isValidAccountNumber("4233"));
        assertFalse(StringUtil.isValidAccountNumber("4239"));
        assertFalse(StringUtil.isValidAccountNumber("42342"));
        assertFalse(StringUtil.isValidAccountNumber("4293"));
        assertFalse(StringUtil.isValidAccountNumber("4299"));
        assertFalse(StringUtil.isValidAccountNumber("42942"));
        assertFalse(StringUtil.isValidAccountNumber("42423"));
        assertFalse(StringUtil.isValidAccountNumber("42429"));
        assertTrue(StringUtil.isValidAccountNumber("424242"));
    }

    /**
     * Method under test: {@link StringUtil#isValidAmountOfMoney(String)}
     */
    @Test
    void testIsValidAmountOfMoney() {
        assertTrue(StringUtil.isValidAmountOfMoney("10"));
        assertFalse(StringUtil.isValidAmountOfMoney("foo"));
        assertTrue(StringUtil.isValidAmountOfMoney("9"));
        assertTrue(StringUtil.isValidAmountOfMoney("42"));
        assertFalse(StringUtil.isValidAmountOfMoney(""));
        assertTrue(StringUtil.isValidAmountOfMoney("1010"));
        assertTrue(StringUtil.isValidAmountOfMoney("109"));
        assertTrue(StringUtil.isValidAmountOfMoney("1042"));
        assertTrue(StringUtil.isValidAmountOfMoney("910"));
        assertTrue(StringUtil.isValidAmountOfMoney("99"));
        assertTrue(StringUtil.isValidAmountOfMoney("942"));
        assertTrue(StringUtil.isValidAmountOfMoney("4210"));
        assertTrue(StringUtil.isValidAmountOfMoney("429"));
        assertTrue(StringUtil.isValidAmountOfMoney("4242"));
        assertTrue(StringUtil.isValidAmountOfMoney("101010"));
        assertTrue(StringUtil.isValidAmountOfMoney("10109"));
        assertTrue(StringUtil.isValidAmountOfMoney("101042"));
        assertTrue(StringUtil.isValidAmountOfMoney("10910"));
        assertTrue(StringUtil.isValidAmountOfMoney("1099"));
        assertTrue(StringUtil.isValidAmountOfMoney("10942"));
        assertTrue(StringUtil.isValidAmountOfMoney("104210"));
        assertTrue(StringUtil.isValidAmountOfMoney("10429"));
        assertTrue(StringUtil.isValidAmountOfMoney("104242"));
        assertTrue(StringUtil.isValidAmountOfMoney("91010"));
        assertTrue(StringUtil.isValidAmountOfMoney("9109"));
        assertTrue(StringUtil.isValidAmountOfMoney("91042"));
        assertTrue(StringUtil.isValidAmountOfMoney("9910"));
        assertTrue(StringUtil.isValidAmountOfMoney("999"));
        assertTrue(StringUtil.isValidAmountOfMoney("9942"));
        assertTrue(StringUtil.isValidAmountOfMoney("94210"));
        assertTrue(StringUtil.isValidAmountOfMoney("9429"));
        assertTrue(StringUtil.isValidAmountOfMoney("94242"));
        assertTrue(StringUtil.isValidAmountOfMoney("421010"));
        assertTrue(StringUtil.isValidAmountOfMoney("42109"));
        assertTrue(StringUtil.isValidAmountOfMoney("421042"));
        assertTrue(StringUtil.isValidAmountOfMoney("42910"));
        assertTrue(StringUtil.isValidAmountOfMoney("4299"));
        assertTrue(StringUtil.isValidAmountOfMoney("42942"));
        assertTrue(StringUtil.isValidAmountOfMoney("424210"));
        assertTrue(StringUtil.isValidAmountOfMoney("42429"));
        assertTrue(StringUtil.isValidAmountOfMoney("424242"));
    }
}

