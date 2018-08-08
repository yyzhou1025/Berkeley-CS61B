import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    
    private static Scanner scanner;
    
    public static void main(String[] args) throws FileNotFoundException {
        int minLength = 4;
        //In in = new In("words.txt");
//        File file = new File("words.txt");
//        scanner = new Scanner(file);
        
        Palindrome palindrome = new Palindrome();
        //System.out.println(sc.nextLine());
//        while (sc.hasNext()) {
//            String word = sc.next();
//            if (word.length() >= minLength && palindrome.isPalindrome(word)) {
//                System.out.println(word);
//            }
//        }
        
        try {
            scanner = new Scanner(new File("words.txt"), "latin1");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] wordsFromText = line.split("\\W");
                OffByN cc = new OffByN(5);

                for (String word : wordsFromText) {
                    if (word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
                        System.out.println(word);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Cannot find the file");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    } 
}
