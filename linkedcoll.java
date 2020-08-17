import java.util.*;
class linkedcoll{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] a={"A","B","C","D"};
        ArrayList<String> list=powerSet(a);
        Collections.sort(list);
        System.out.println(list);
        sc.close();
    }
    static ArrayList<String> powerSet(String[] a){
       long n=(long)Math.pow(2, a.length);
       ArrayList<String> outer=new ArrayList<>();
       for(int i=0;i<n;i++){
            StringBuilder stringBuilder=new StringBuilder();
            for(int j=0;j<a.length;j++){
                if((i&(1<<j))!=0) stringBuilder.append(a[j]);
            }
            outer.add(stringBuilder.toString());
       }
       return outer;
    }
}