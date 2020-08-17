import java.util.*;
class ebox{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StringBuilder stringBuilder=new StringBuilder();
        Stack<String> stack = new Stack<String>(); 
        int n=sc.nextInt();
        int bCount=n-1;
        for(int i=1;i<=bCount;i++) stringBuilder.append("b");
        stringBuilder.append("*");
        for(int i=1;i<=bCount;i++) stringBuilder.append("b");
        stack.add(stringBuilder.toString());
        System.out.print(stringBuilder.toString());
        System.out.println();
        stringBuilder.setLength(0);
        int starOne=n-1,iCount=1;
        starOne--;
        for(int i=1;i<=(n-2);i++){
            bCount=starOne-1;
            for(int j=0;j<=bCount;j++) stringBuilder.append("b");
            stringBuilder.append("*");
            for(int j=1;j<=iCount;j++) stringBuilder.append("i");
            stringBuilder.append("*");
            for(int j=0;j<=bCount;j++) stringBuilder.append("b");
            stack.add(stringBuilder.toString());
            System.out.println(stringBuilder.toString());
            starOne--;iCount+=2;
            stringBuilder.setLength(0);
        }
        for(int i=1;i<=1+2*(n-1);i++) stringBuilder.append("*");
        stack.add(stringBuilder.toString());
        System.out.print(stringBuilder.toString());
        System.out.println();
        Enumeration<String> enu = stack.elements(); 
        
        while (enu.hasMoreElements()) { 
            System.out.println(enu.nextElement()); 
        } 
        sc.close();
    }
}