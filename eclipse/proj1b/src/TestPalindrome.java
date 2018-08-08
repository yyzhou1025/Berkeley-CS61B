import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        @SuppressWarnings("rawtypes")
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } 
    
    @Test
    public void testisPalindrome() {
        assertFalse(palindrome.isPalindrome("Abba"));
//        assertTrue(palindrome.isPalindrome("noon"));
//        assertTrue(palindrome.isPalindrome("abssbs"));
//        assertFalse(palindrome.isPalindrome("Abba"));
    }
    
    @Test
    public void testEqualChars() {
        OffByOne obo = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", obo));
        assertFalse(palindrome.isPalindrome("flakeer", obo));
        assertTrue(palindrome.isPalindrome("hajbi", obo));
        
    }
}
