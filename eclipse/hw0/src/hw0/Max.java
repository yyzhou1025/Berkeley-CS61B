package hw0;
/**
 * create a method to find the maximum value in an array.
 * You can assume that all the values in the array are greater than 0 or equal to 0.
 * @author YuanyuanZhou
 *
 */
public class Max {
	public static int max(int[] m) {
		/*if array is null or empty*/
		if (m.length == 0 || m == null) {
			return -1;
		} else {
			int max;
			max = m[0];
			for (int i = 1; i < m.length; i++) {
				if (m[i] > max) {
					max = m[i];
				}				
			}
			return max;
		}
		
	}
	
	public static void main(String[] args) {
		int numbers[] = new int[]{9, 2, 15, 2, 22, 10, 6};
		System.out.println(max(numbers));
	}
	

}
