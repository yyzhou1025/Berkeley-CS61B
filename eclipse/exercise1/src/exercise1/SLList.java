package exercise1;

/** An SLList is a list of integers, which hides the terrible truth
 * of the nakedness within. */
public class SLList {   
      private static class IntNode {
              public int item;
              public IntNode next;

              public IntNode(int i, IntNode n) {
                      item = i;
                      next = n;
              }
      } 

      /* The first item (if it exists) is at sentinel.next. */
      private IntNode sentinel;
      private int size; 

      /** Creates an empty SLList. */
      public SLList() {
              sentinel = new IntNode(63, null);
              size = 0;
      }

      public SLList(int x) {
              sentinel = new IntNode(63, null);
              sentinel.next = new IntNode(x, null);
              size = 1;
      }
      
      /**
       * constructor that takes in an array of list.
       * @param x array 
       */
      public SLList(int[] x) {
          sentinel = new IntNode(63, null);
          for (int i = 0; i < x.length; i++) {
             this.addLast(x[i]);            
          }
          
          size = x.length;
          
      }

      /** Adds x to the front of the list. */
      public void addFirst(int x) {
              sentinel.next = new IntNode(x, sentinel.next);
              size = size + 1;
      }

      /** Returns the first item in the list. */
      public int getFirst() {
              return sentinel.next.item;
      }

      /** Adds x to the end of the list. */
      public void addLast(int x) {
              size = size + 1;                

              IntNode p = sentinel;

              /* Advance p to the end of the list. */
              while (p.next != null) {
                      p = p.next;
              }

              p.next = new IntNode(x, null);
      }
      
      /** Delete the first item in the list*/
      public void deleteFirst() {
          size = size - 1;
          sentinel.next = sentinel.next.next;
      }
      
      /** Returns the size of the list. */
      public int size() {
              return size;
      }

      public static void main(String[] args) {
              /* Creates a list of one integer, namely 10 */
          int[] X = {6, 3, 4, 5, 6, 6};
              SLList L = new SLList(X);
//              L.addLast(20);
//              L.addFirst(10);
//              L.addLast(30);
//              L.addFirst(9);
//              L.deleteFirst();
              
              System.out.println(L.size());
              System.out.println(L.getFirst());
              
      }
}
