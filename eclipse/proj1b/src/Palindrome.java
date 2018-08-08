

/**
 * A class for palindrome operations.
 * @author YuanyuanZhou
 *
 */
public class Palindrome {
    
    /**
     * Given a String, wordToDeque should return a Deque where the characters appear in the same order as in the String. 
     * For example, if the word is “persiflage”, then the returned Deque should have ‘p’ at the front, followed by ‘e’, and so forth.
     * @param word
     * @return
     */
    public Deque<Character> wordToDeque(String word) {
       Deque<Character> wordDeque =  new LinkedListDeque<Character>();
       for (int i = 0; i < word.length(); i++) {
           char x = word.charAt(i);
           wordDeque.addLast(x);
       }
       return wordDeque;
    }
    
    /**
     * The isPalindrome method should return true if the given word is a palindrome, and false otherwise.
     * A palindrome is defined as a word that is the same whether it is read forwards or backwards.
     * Any word of length 1 or 0 is a palindrome.
     * ‘A’ and ‘a’ should not be considered equal.
     * @param word
     * @return
     */
    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        Deque<Character> deque1 = new LinkedListDeque<Character>();
        int length = deque.size();
        Deque<Character> saveDeque = wordToDeque(word);
        for (int i = 0; i < length; i++) {
            char oldLast = deque.removeLast();
            deque1.addLast(oldLast);
        }
        for (int i = 0; i < length; i++) {
            if (!(saveDeque.get(i).equals(deque1.get(i)))) {
                return false;
            }
            
        }
        return true;
        
    }
    
    /**
     * The method will return true if the word is a palindrome according to the character comparison test.provided by the CharacterComparator passed in as argument cc.
     * @param word
     * @param cc
     * @return
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
       Deque<Character> deque = wordToDeque(word);
       if (word.length() == 0 || word.length() == 1) {
           return true;
       }
       //if word's length is even
           int length = word.length() / 2;
           for (int i = 0; i < length; i++) {
               char first = deque.removeFirst();
               char last = deque.removeLast();
               if (!cc.equalChars(first, last)) {
                   return false;
               }
           }
           return true;
        
    }
    
   
    
}
