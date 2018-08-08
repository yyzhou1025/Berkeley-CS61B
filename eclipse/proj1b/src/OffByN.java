/**
 * The second edit for offbyone.
 * @author YuanyuanZhou
 *
 */
public class OffByN implements CharacterComparator{
    /**
     * instance variable.
     * off by n 
     */
    private  int  n;
    
    /**
     * constructor.
     * @param N
     */
    public OffByN(int N) {
        n = N;
    }
   /**
    * Returns true if characters are equal by the rules of the implementing class.
    * @param x
    * @param y
    * @return true or false
    */
    public boolean equalChars(char x, char y) {
        if (Math.abs(x - y) == n) {
            return true;
        } else {
            return false;
        }
    }
    
}
