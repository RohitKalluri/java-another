import java.util.*;
import java.io.*;
class UNITGCD {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Fastx in = new Fastx(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int evenCount=0;
        int k;
        int t=in.nextInt();
        while(t-->0){
        int n=in.nextInt();
        evenCount=0;
        for(int i=1;i<=n;i++){
        if(i%2==0){
        evenCount++;
        }
        }
        evenCount=evenCount-1;
        out.println((1+evenCount)+"");
        if(n==1)
        out.println("1 1"+"");
        else if(n==2)
        out.println("2 1 2"+"");
        else{
            k=4;
            out.println("3 1 2 3");
            while(evenCount-->0){
                out.print("2"+" "+k+++" ");
                if(k<n)
                out.println(k++);
            }
            }
        }
            out.close();
        }
    }

class Fastx {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private Fastx.SpaceCharFilter filter;

    public Fastx(InputStream stream) {
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

