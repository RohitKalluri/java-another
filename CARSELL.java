import java.io.*;
import java.util.*;
class CARSELL
{ 
	public static void main (String[] args) 
	{
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    FastReader in = new FastReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    int testcases=in.nextInt();
    int n,j=0,x;
    long sum=0L;
    int mod=1000000007;
    Object[] arr;
    Comparator<Object> comparator=Collections.reverseOrder();
    while(testcases-->0){
        n=in.nextInt();
        arr=new Object[n];
        for(int i=0;i<arr.length;i++)
        arr[i]=in.nextInt();
        Arrays.sort(arr, comparator);
        j=0;sum=0L;x=0;
        for(int i=0;i<arr.length;i++){
            x=(int)arr[i]-j;
            if(x<0)x=0;
            sum+=x;
            j++;
        }
        out.println(sum%mod+"");
    }
    out.close();
}
class sorted{
    void sort(long[] arr) {
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
}

 
class FastReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private FastReader.SpaceCharFilter filter;

    public FastReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {

        if (numChars == -1)
            throw new InputMismatchException();

        if (curChar >= numChars) {

            curChar = 0;

            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }

            if (numChars <= 0)
                return -1;
        }

        return buf[curChar++];
    }

    public int nextInt() {

        int c = read();

        while (isSpaceChar(c))
            c = read();

        int sgn = 1;

        if (c == '-') {
            sgn = -1;
            c = read();
        }

        int res = 0;

        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();

            res *= 10;
            res += c - '0';
            c = read();
        }
        while (!isSpaceChar(c));

        return res * sgn;
    }

    public String next() {

        int c = read();

        while (isSpaceChar(c))
            c = read();

        StringBuilder res = new StringBuilder();

        do {
            res.appendCodePoint(c);
            c = read();
        }
        while (!isSpaceChar(c));

        return res.toString();
    }

    public boolean isSpaceChar(int c) {

        if (filter != null)
            return filter.isSpaceChar(c);

        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);

    }
    

}
