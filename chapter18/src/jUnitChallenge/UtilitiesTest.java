package jUnitChallenge;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {

    private Utilities util;

    @Before
    public void setup() {
        util = new Utilities();
    }

    @Test
    public void everyNthChar() {
        char[] output = util.everyNthChar(new char[]{'h', 'e', 'l', 'l', 'o'}, 2);
        assertArrayEquals(new char[]{'e', 'l'}, output);
        char[] output2 = util.everyNthChar(new char[]{'h', 'e', 'l', 'l', 'o'}, 8);
        assertArrayEquals(new char[]{'h', 'e', 'l', 'l', 'o'}, output2);
    }

    @Test
    public void removePairs() {

        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
        assertNull("Did not get null returned when argument passed was null", util.removePairs(null));
        assertEquals("A", util.removePairs("A"));
        assertEquals("", util.removePairs(""));
    }


    @Test
    public void converter() {
        int output = util.converter(10, 5);
        assertEquals(300, output, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void converter_arithmeticException() {
        util.converter(10, 0);
    }

    @Test
    public void nullIfOddLength() {
        String output = util.nullIfOddLength("ABCD");
        assertNotNull(output);
        output = util.nullIfOddLength("ABCDE");
        assertNull(output);
    }
}