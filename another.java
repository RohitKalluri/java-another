import java.util.*;
public class another {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k;
        int n=sc.nextInt();
        int count=0;
        for(int i=1;i<=n;i++){
            if(i%2==0)
            count+=1;
        }
        count=count-1;
        System.out.println(count);
        if(n==1)
        System.out.println("1 1"+"");
        else if(n==2)
        System.out.println("2 1 2"+"");
        else{
            k=1;
            while(count-->=0){
                System.out.println("2"+" "+k+" "+k+1);
                k++;
            }
            }
            sc.close();
        }
    }
