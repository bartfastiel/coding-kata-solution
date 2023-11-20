import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

    @Test
    void expectEmptyString_whenStringContains0() {
        String solution = Main.KUniqueCharacters("0");
        Assertions.assertEquals("", solution);
    }

    @Test
    void expectA_whenStringContains1a() {
        String solution = Main.KUniqueCharacters("1a");
        Assertions.assertEquals("a", solution);
    }

}