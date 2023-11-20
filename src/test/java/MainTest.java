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

}