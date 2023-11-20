import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {

    public static String KUniqueCharacters(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Empty string");
        }
        int numberOfUniqueCharacters = Integer.parseInt(str.substring(0, 1));
        String remainingString = str.substring(1);
        int[] codePoints = remainingString.codePoints().toArray();

        int startOfLongestSequence = 0;
        int lengthOfLongestSequence = 0;

        for (var startOfSequence = 0; startOfSequence < codePoints.length; startOfSequence++) {
            int lengthOfSequence = getLengthOfSequence(codePoints, startOfSequence, numberOfUniqueCharacters);
            if (lengthOfSequence > lengthOfLongestSequence) {
                startOfLongestSequence = startOfSequence;
                lengthOfLongestSequence = lengthOfSequence;
            }

            // potential optimization (for later): if we found a sequence of 3, then last two characters can be skipped
        }

        return remainingString.substring(startOfLongestSequence, startOfLongestSequence + lengthOfLongestSequence);
    }

    private static int getLengthOfSequence(int[] codePoints, int startOfSequence, int numberOfUniqueCharacters) {
        Set<Integer> uniqueCharacters = new HashSet<>();
        uniqueCharacters.add(codePoints[startOfSequence]);
        var j = startOfSequence + 1;
        for (; j < codePoints.length; j++) {
            if (uniqueCharacters.contains(codePoints[j])) {
                continue;
            }
            uniqueCharacters.add(codePoints[j]);
            if (uniqueCharacters.size() > numberOfUniqueCharacters) {
                break;
            }
        }

        return j - startOfSequence;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print(KUniqueCharacters(s.nextLine()));
    }

}

