import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MainTest {

    @Test
    void expectException_whenStringIsEmpty() {
        try {
            Main.KUniqueCharacters("");
            Assertions.fail("Empty string did not raise exception");
        } catch (IllegalArgumentException e) {
            // well done: illegal argument detected
        }
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0=",
            "1a=a",
            "2ab=ab",
            "1ab=a",
    }, delimiter = '=')
    void check(String input, String expected) {
        String solution = Main.KUniqueCharacters(input);
        if (expected == null) {
            expected = "";
        }
        Assertions.assertEquals(expected, solution);
    }
}