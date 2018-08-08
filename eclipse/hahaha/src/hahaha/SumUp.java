package hahaha;
/**
 * Given an array of integers A and an integer k, 
 * return true if any two numbers in the array sum up to k, and return false otherwise.
 * @author YuanyuanZhou
 *
 */
public class SumUp {
  
    public boolean sum(int[] A, int K) {
        for (int i = 0; i < A.length; i++) {
            int s = A[i] + A[i + 1];
            if(s == K) {
                return true;
            }
            
        }
        return false;
        
    }
    
    
    

}
