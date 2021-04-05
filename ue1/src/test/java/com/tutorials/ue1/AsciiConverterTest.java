package com.tutorials.ue1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AsciiConverterTest {
    private final PrintStream stdOut = System.out;
    private final ByteArrayOutputStream printCatcher = new ByteArrayOutputStream();
    private String expectedError = "At least the input string has to be provided as string.\n";

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(printCatcher));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(stdOut);
    }

    @Test
    public void testSimpleConvert() {
        String input = "I am a simple input string.";
        String expectedOutput = "73 32 97 109 32 97 32 115 105 109 112 108 101 32 105 110 112 117 116 32 115 " +
                "116 114 105 110 103 46";
        AsciiConverter.main(new String[] {input});

        assertEquals(expectedOutput, printCatcher.toString());
    }

    @Test
    public void whenNoArgumentsPassedProgramNotkilled() {
        assertDoesNotThrow(() -> AsciiConverter.main(new String[] {}));
        assertEquals(expectedError, printCatcher.toString().replace("\r", ""));
    }

    @Test
    public void whenNullProvidedAsArgumentItLogsError() {
        assertDoesNotThrow(() -> AsciiConverter.main(null));
        assertEquals(expectedError, printCatcher.toString().replace("\r", ""));
    }

    @Test
    public void whenReverseRequestedCanBeReverted() {
        String input = "73 32 97 109 32 97 32 115 105 109 112 108 101 32 105 110 112 117 116 32 115 " +
                "116 114 105 110 103 46";
        String expectedOuput = "I am a simple input string.\n";

        AsciiConverter.main(new String[] {"-d", input});
        assertEquals(expectedOuput, printCatcher.toString().replace("\r", ""));
    }
}
