import java.util.Scanner;

class Main {

    public static String KUniqueCharacters(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Empty string");
        }
        return str;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print(KUniqueCharacters(s.nextLine()));
    }

}

