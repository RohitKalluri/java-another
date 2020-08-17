import java.util.*;
public class cses {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        long[] a=new long[(int)n-1];
        for(int i=0;i<n-1;i++) a[i]=sc.nextLong();
        System.out.println(((n*(n+1))/2)-Arrays.stream(a).sum());
        sc.close();
    }
}