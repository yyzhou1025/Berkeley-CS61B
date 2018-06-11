public class HelloNumbers {
    public static void main(String[] args) {
    	int sum = 0;
        for (int i = 0; i < 10; i++) {
        	for (int j = 0; j < i + 1; j++) {
        		sum = sum + j;
        	}
        	System.out.println(sum);
        	sum = 0;
        }
    }
}