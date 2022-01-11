package jUnitChallenge;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {

    @Test
    public void everyNthChar() {
        fail("This test has not been implemented");
    }

    @Test
    public void removePairs() {
        assertEquals("ABCDEF", new Utilities().removePairs("AABCDDEFF") );
        assertEquals("ABCABDEF", new Utilities().removePairs("ABCCABDEEF") );
    }

    @Test
    public void converter() {
        fail("This test has not been implemented");
    }

    @Test
    public void nullIfOddLength() {
        fail("This test has not been implemented");
    }
}