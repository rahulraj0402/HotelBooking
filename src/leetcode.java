import java.util.Arrays;
import java.util.HashMap;

public class leetcode {
    public static void main(String[] args) {

    int nums[] = {1,5,9,1,5,9};
    int index = 2;
    int k = 3;

        System.out.println(containsDublicate3(nums ,2,3));

    }



    static boolean containsDublicate3(int nums[] , int indexDiff , int valueDiff){
        int n = nums.length;
        for (int i = 0 ; i < n ; i++){
            for (int j = i + 1 ; j < n ; j++){
                if (Math.abs(nums[i] - nums[j]) <= valueDiff && j-i <= indexDiff ){
                    return true;
                }
            }
        }

        return false;
    }


    static public int[] bs(int[][] intervals,int k){
        int ans[]=null;
        int i=0,j=intervals.length-1;
        while(i<=j){

            int mid=(i+j)/2;
            if(intervals[mid][0]>=k){
                ans=intervals[mid];
                j=mid-1;
            }else
                i=mid+1;

        }
        return ans;

    }


    //[3,4],[2,3],[1,2]]
         static int[] findRightInterval(int[][] intervals) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            int[] first = new int[intervals.length];
            for (int i = 0; i < intervals.length; i++) {
                hm.put(intervals[i][0], i);
                first[i] = intervals[i][0];
            }
            Arrays.sort(first);
            int[] ans = new int[intervals.length];

             for( int i  = 0 ; i< intervals.length;i++)
             {
                 int key = binarysearch(first,intervals[i][1]);
                 if(key==first.length)
                     ans[i]=-1;
                 else if(key==0)
                 {
                     if(intervals[i][1] <= first[0])
                         ans[i]=hm.get(first[0]);
                     else
                         ans[i]=-1;
                 }
                 else
                     ans[i] = hm.get(first[key]);
             }
            return ans;
        }

     static int binarysearch(int[] arr, int target) {
            int s = 0;
            int e = arr.length - 1;
            while (s < e) {
                int mid = s + (e - s) / 2;
                if (arr[mid] < target)
                    s = mid + 1;
                else
                    e = mid;
            }
            return s;
        }

    static int [] rightInterval(int [][] intervals){
        int ans[] = new int[intervals.length];

        for (int i = 0 ; i < intervals.length ; i++){
            int idx = -1;
            int minStart = Integer.MAX_VALUE;

            for (int j = 0 ; j < intervals.length ; j++){
                if (intervals[j][0] >=intervals[i][1] && minStart > intervals[j][0]){
                    idx = j;
                    minStart=intervals[j][0];
                }
                ans[i] = idx;
            }
        }
        return ans;
    }
}
