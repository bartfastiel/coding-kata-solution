import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MainTest {

    @ParameterizedTest
    @ValueSource(strings = {
            // number of unique characters must be a number
            "",
            ":",
            "X",

            // number of unique characters must be >0 and <6
            "0",
            "0asd",
            "7",
            "7asd",
            "9",
            "9asd",
    })
    void expectException_whenInputIsInvalid(String input) {
        try {
            Main.KUniqueCharacters(input);
            Assertions.fail("Did not raise exception for String '"+input+"'");
        } catch (IllegalArgumentException e) {
            // well done: illegal argument detected
        }
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1a=a",
            "2ab=ab",
            "1ab=a",
            "1abb=bb",
            "1aabb=aa",
            "2aabbacbaa=aabba",
            "3aabacbebebe=cbebebe",
            "2aabbcbbbadef=bbcbbb",
    }, delimiter = '=')
    void check(String input, String expected) {
        String solution = Main.KUniqueCharacters(input);
        if (expected == null) {
            expected = "";
        }
        Assertions.assertEquals(expected, solution);
    }

    @Test
    void performanceTest() {
        long startTime = System.currentTimeMillis();
        String input = "6" + "a".repeat(100_000_000);
        Main.KUniqueCharacters(input);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Duration: " + duration + "ms");
    }
}