package exercise1;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
            first = f;
            rest = r;
    }

    /** Return the size of the list using... recursion! */
    public int size() {
        /**base case*/
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
            
    }
    
    /**If two numbers are the same, add them together. */
    public void addAdjacent() {
        IntList p = this;
        if (p.rest == null) {
            return;
        }
        IntList s = p;
        while (s.rest != null) {
            if (s.first == s.rest.first) {
                s.first = s.first * 2;
                s.rest = s.rest.rest;
                s = p;
            } else {
                s = s.rest;
            }
            
        }
    }

    /** Return the size of the list using no recursion! */
    public int iterativeSize() {
        if (rest == null ) {
            return 1;
        } else {
            int i = 1;
            while (this.rest != null) {
                this.rest = this.rest.rest;
                i = i + 1;
            }
            return i;
        }
        
    }

    /** Returns the ith value in this list.*/
    public int get(int i) {
        if (i == 0) {
            return first;
        } else {
            return this.rest.get(i - 1);
        }
        
       
            
    }
    
    public static IntList incrList(IntList L, int x) {
        if (L == null) {      
            return null;
        } else {
            IntList newL = incrList(L.rest, x);
            IntList newnewL = new IntList(L.first + x, newL);
            return newnewL;
        }
        
     }

     /** Returns an IntList identical to L, but with
       * each element incremented by x. Not allowed to use
       * the 'new' keyword. */
     public static IntList dincrList(IntList L, int x) {
         IntList newL = L;
         while (newL != null) {
             newL.first = newL.first + x;
             newL = newL.rest;
             
         }
         return L;
     }

    public static void main(String[] args) {
            IntList L = new IntList(15, null);
            L = new IntList(10, L);
            L = new IntList(5, L);
            L = new IntList(5, L);
            L.addAdjacent();
            System.out.println(L.get(0));
            System.out.println(L.get(1));
            
            //System.out.println(L.iterativeSize());
            //System.out.println(L.size());
            //System.out.println(L.get(0));
            //System.out.println(incrList(L, 3));
            
    }
} 