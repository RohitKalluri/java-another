import java.util.*;
import java.io.*;
public class lastone {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Fastc in = new Fastc(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int k;
        int t=in.nextInt();
        int n;
        while(t-->0){
        n=in.nextInt();
        if(n==1){
            out.println("1\n 1 1"+"");
        }
        else if(n==2){
            out.println("1\n 2 1 2"+"");
        }
        else{
            out.println(n/2);
            out.println("3 1 2 3"+"");
            if(n%2!=0){
                k=4;
                while(k<=n){
                    out.println("2 "+k+++" "+k+++"");
                }
            }
            else{
                k=4;
                while(k<n){
                    out.println("2"+" "+k+++" "+k+++"");
                }
                out.println("1"+" "+n+"");
                
            }
        }
    }
        out.close();

    }
}
class Fastc {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private Fastc.SpaceCharFilter filter;

    public Fastc(InputStream stream) {
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

