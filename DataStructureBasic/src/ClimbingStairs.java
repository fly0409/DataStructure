import java.util.HashMap;

public class ClimbingStairs {

    public static int climbStairs(int n) {
        HashMap<Integer, Integer> memoize = new HashMap<Integer, Integer>();
        memoize.put(1,1);
        memoize.put(2,2);
        return recurrsion(n,memoize);
    }

    public static int recurrsion(int n,HashMap<Integer, Integer> memo){
        if( n==2){
            return 2;
        }else if(n ==1){
            return 1;
        }else{
            if(memo.get(n)!=null){
                return memo.get(n);
            }else{
                memo.put(n,recurrsion(n-1,memo)+recurrsion(n-2,memo));
                return memo.get(n);
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(2);
//        System.out.println(climbStairs(2));
    }
}
