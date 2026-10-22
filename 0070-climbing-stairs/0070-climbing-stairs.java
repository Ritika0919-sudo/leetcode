class Solution {
    public int climbStairs(int n) {
        int current;
        if(n<=2) {
            return n ;
        }
        int a = 1;
        int b = 2;
        for (int i = 3;i<=n ;i ++)
        {
            current = a+b;
            a=b;
            b= current ;
        }
        return b;
    }
}