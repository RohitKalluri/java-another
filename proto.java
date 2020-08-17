import java.util.*;
public class proto {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[] arr=new long[n];
        long[] a=new long[n];
        for(int i=0;i<arr.length;i++)
        arr[i]=sc.nextLong();
        sort(arr);
        for(int i=0;i<arr.length;i++)
        System.out.print(arr[i]+" ");
        int k=0;
        for(int i=arr.length-1;i>=0;i--)
        a[k++]=arr[i];
        for(int i=0;i<arr.length;i++)
        System.out.print(a[i]+" ");
        System.out.println();
        long j=0L,sum=0L,x;
        for(int i=0;i<a.length;i++){
            x=a[i]-j;
            if(x<0)x=0;
            sum+=x;
            j++;
        }
        System.out.println(sum);
        sc.close();
    } 
    static void sort(long[] arr) {
        int n = arr.length, mid, h, s, l, i, j, k;
        long[] res = new long[n];
        for (s = 1; s < n; s <<= 1) {
            for (l = 0; l < n - 1; l += (s << 1)) {
                h = Math.min(l + (s << 1) - 1, n - 1);
                mid = Math.min(l + s - 1, n - 1);
                i = l;
                j = mid + 1;
                k = l;
                while (i <= mid && j <= h) res[k++] = (arr[i] <= arr[j] ? arr[i++] : arr[j++]);
                while (i <= mid) res[k++] = arr[i++];
                while (j <= h) res[k++] = arr[j++];
                for (k = l; k <= h; k++) arr[k] = res[k];
            }
        }
    }
}