import java.util.*;
import java.io.*;
public class COVIDLQ {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Fast in = new Fast(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int testcases=in.nextInt();
        int n,j;
        boolean flag;
        int[] arr,indexes;
        while(testcases-->0){
            n=in.nextInt();
            arr=new int[n];
            for(int i=0;i<arr.length;i++)
            arr[i]=in.nextInt();
            indexes=new int[n];
            Arrays.fill(indexes, -1);
            j=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]==1)
                indexes[j++]=arr[i];
            }
            flag=false;
            for(int i=0;i<indexes.length;i++){
                try{
                if(indexes[i+1]!=-1&&indexes[i]!=-1){
                    if(indexes[i+1]!=indexes[i]+6){
                        flag=true;
                        break;
                    }
                }
            }
            catch(Exception e){

            }
            }
            if(flag) out.println("NO"+"");
            else out.println("YES"+"");
        }
        out.close();
    }
}
class Fast {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private FastReader.SpaceCharFilter filter;

    public Fast(InputStream stream) {
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
