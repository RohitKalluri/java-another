import java.util.*;
import java.io.*;
class test { 
	public static long SubArraySum(int arr[], int n) 
	{ 
		long temp=0; 
        int count=0;
		for (int i = 0; i < n; i ++) 
		{ 
			temp=1; 
			for (int j = i; j < n; j ++) 
			{
                temp=temp*arr[j];
                if(function(temp))
                count++;
			} 
		} 
		return count; 
    } 
    static boolean function(long n){
        if(n%2==0&&n%4!=0)
            return false;
        else
            return true;
    }
	public static void main(String[] args) 
	{ 
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Fastlast sc= new Fastlast(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int arr[];
        int n,t=sc.nextInt();
        while(t-->0){
            n=sc.nextInt();
            arr=new int[n];
            for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
            out.println(SubArraySum(arr, n));    
        }
        out.close();
	} 
}  
class Fastlast {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private Fastlast.SpaceCharFilter filter;

    public Fastlast(InputStream stream) {
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


