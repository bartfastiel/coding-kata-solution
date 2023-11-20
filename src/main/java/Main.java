import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {

    enum Mode {
        INCREASE_LENGTH,
        INCREASE_START,
    }

    public static String KUniqueCharacters(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Empty string");
        }
        int numberOfUniqueCharacters = Integer.parseInt(str.substring(0, 1));
        String remainingString = str.substring(1);

        // do not use char, because the string might contain foreign characters or emojis
        int[] codePoints = remainingString.codePoints().toArray();

        int startOfLongestSequence = 0;
        int lengthOfLongestSequence = 0;

        Map<Integer, Integer> uniqueCharacterHistogram = new HashMap<>();

        var startOfSequence = 0;
        var lengthOfSequence = 0;
        Mode mode = Mode.INCREASE_LENGTH;
        while (startOfSequence + lengthOfSequence < codePoints.length) {

            // we either increase the size of our moving window until we have enough unique characters
            if (mode == Mode.INCREASE_LENGTH) {
                lengthOfSequence++;
            }

            // or we move the window until we found a spot, where more characters can be added
            else {
                startOfSequence++;
            }

            var lastCodePointOfNewSequence = codePoints[startOfSequence + lengthOfSequence - 1];
            uniqueCharacterHistogram.merge(lastCodePointOfNewSequence, 1, Integer::sum);

            if (mode == Mode.INCREASE_START) {
                var firstCharacterOfOldSequence = codePoints[startOfSequence - 1];
                uniqueCharacterHistogram.compute(firstCharacterOfOldSequence, (key, value) -> value > 1 ? --value : null);
            }

            if (uniqueCharacterHistogram.size() > numberOfUniqueCharacters) {
                mode = Mode.INCREASE_START;
            } else {
                mode = Mode.INCREASE_LENGTH;
                if (lengthOfSequence > lengthOfLongestSequence) {
                    startOfLongestSequence = startOfSequence;
                    lengthOfLongestSequence = lengthOfSequence;
                }
            }
        }

        return remainingString.substring(startOfLongestSequence, startOfLongestSequence + lengthOfLongestSequence);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print(KUniqueCharacters(s.nextLine()));
    }

}

