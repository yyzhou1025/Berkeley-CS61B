import static org.junit.Assert.*;

import org.junit.Test;

public class TestOffByOne {
    
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = (CharacterComparator) new OffByOne();
    
    @Test
    public void testEqualChars() {
        OffByOne obo = new OffByOne();
        assertTrue(obo.equalChars('a', 'b'));
        assertTrue(obo.equalChars('r', 'q'));
        assertTrue(obo.equalChars('%', '&'));
        assertFalse(obo.equalChars('a', 'c'));
        assertFalse(obo.equalChars('z', 'a'));
        assertFalse(obo.equalChars('a', 'a'));
        assertFalse(obo.equalChars('a', 'A'));
        
        
        
        
    }
    
}
