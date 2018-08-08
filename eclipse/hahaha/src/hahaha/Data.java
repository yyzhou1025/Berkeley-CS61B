package hahaha;

public class Data {
    private static String[] rs;
    
    private static void printStringArray(String[] s) {
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println();
    }
    
    private static void fillMany(String[] d) {
        System.arraycopy(Data.rs, 0, d, 0, d.length);
    }
    
    private static void fillOne(String d) {
        d = Data.rs[0];
    }
    
    public static void main (String[] args) {
        String a = "alice";
        String b = "bob";
        String c = "carol";
        String d = "dan";
        String[][] twod = {{a,b}, {c,d}};
        
        Data.rs = new String[] { "fritz", "gritz"};
        String[] x = twod[0];
        printStringArray(x);
        fillOne(x[0]);
        printStringArray(x);
        fillMany(x);
        printStringArray(x);
        
        
        
    }
 
}
