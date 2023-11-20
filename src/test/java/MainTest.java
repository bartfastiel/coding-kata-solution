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