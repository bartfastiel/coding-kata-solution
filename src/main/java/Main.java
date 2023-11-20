import java.util.Scanner;

class Main {

    public static String KUniqueCharacters(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Empty string");
        }
        int numberOfUniqueCharacters = Integer.parseInt(str.substring(0, 1));
        return str.substring(1, numberOfUniqueCharacters + 1);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print(KUniqueCharacters(s.nextLine()));
    }

}

