import java.util.*;
class leetcode {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[][] intervals={{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
        sc.close();
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a,b)->(a[1]-b[1]));
        for(int[] a:intervals) System.out.print(Arrays.toString(a)+" ");
        int[] last = intervals[0];
        int count = 1;
        for(int i = 1; i < intervals.length; i ++) {
            System.out.println(last[1]+" "+intervals[i][0]);
            if(last[1] <= intervals[i][0]) {
                count ++;
                last = intervals[i];
            }
            
        }
        
        return intervals.length - count;
    }
  
}


