package jUnitChallenge;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(Parameterized.class)
public class UtilitiesTestParameterized {
    private String output;
    private String input;
    private Utilities util;

    public UtilitiesTestParameterized(String output, String input) {
        this.output = output;
        this.input = input;
    }


    @Before
    public void setup() {
        util = new Utilities();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][]{
                {"ABCDEF", "ABCDEFF"},
                {"AB8EFG", "AB88EFFG"},
                {"123456", "112233445566"},
                {"ZYZQB", "ZYZQQB"},
                {"A", "A"},
        });
    }

    @Test
    public void removePairs() {
        assertEquals(output, util.removePairs(input));
    }


}
