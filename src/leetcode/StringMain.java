package leetcode;


public class StringMain {

    public static void main(String[] args) {

        Strings strings = new Strings();

        String s = "cat cat cat dog";
        int[] students = {1,1,0,0}, sandwiches = {0,1,0,1};

        String str = "abc", t = "bac";

        String pattern = "aba";

        System.out.println(strings.wordPattern(pattern,s));

    }

    public static void imprimirDesdeNHasta100(int n){
        if (n >= 1 && n <= 100){
            System.out.println(n);
            imprimirDesdeNHasta100(n+1);
        }
    }

}
